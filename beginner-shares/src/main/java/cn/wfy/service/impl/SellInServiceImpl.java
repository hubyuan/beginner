package cn.wfy.service.impl;

import cn.wfy.dao.*;
import cn.wfy.entity.*;
import cn.wfy.service.SellInService;
import cn.wfy.utils.BCNPUtils;
import cn.wfy.utils.PoorThreadPool;
import cn.wfy.utils.SnowFlakeGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/28
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SellInServiceImpl implements SellInService {

    private final int BATCH_SIZE = 500;

    @Autowired
    private SellInRepository sellInRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Resource
    private SellOutRepository sellOutRepository;

    @Autowired
    private AccountInfoRepository accountInfoRepository;
    @Autowired
    private SellInService sellInService;

    @Autowired
    private SharesRepository sharesRepository;
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * 1s内发布完成
     * 1776ms 1万
     *
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void releaseShares(SellInVo sellInVo) {

        try {
            //查数据库是否有，有就取消，并且更新入库和交易数据

            //数据库没有，就插入到数据库

            int number = sellInVo.getNumber();

            List<SellOut> matchList = sellOutRepository.isMatch(sellInVo.getCode(), sellInVo.getPrice(), sellInVo.getNumber());
            if (Objects.isNull(matchList) || matchList.size() == 0) {
                //only insert  不交易
                insertAll(matchList, sellInVo);
            } else if (matchList.size() <= number) {
                boolean moneyOk = decreaseMoney(matchList, sellInVo.getPrice(), sellInVo.getAccountId());
                if (!moneyOk) {
                    return;
                }
                //complex deal 交易一部分
                insertApart(matchList, sellInVo);
                dealApart(matchList, sellInVo);
                saveAccountApart(matchList, sellInVo);
                updateShare(sellInVo, matchList);

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    private boolean decreaseMoney(List<SellOut> sellOutList, double price, long accountId) {
        int number = sellOutList.size();
        double prices = sellOutList.stream().mapToDouble(SellOut::getPrice).sum();

        Account repositoryOne = accountRepository.getOne(accountId);
        Double money = repositoryOne.getMoney();
        if (money < prices) {
            return false;
        } else {
            Account account = new Account();
            account.setId(accountId);
            account.setMoney(money - prices);
            Account save = accountRepository.save(account);
            return true;
        }

    }

    private void updateShare(SellInVo sellInVo, List<SellOut> matchList) {

        // update shares
        Optional<Shares> sharesOptional = sharesRepository.findById(sellInVo.getCode());
        Shares shares = sharesOptional.get();

        shares = BCNPUtils.calculation(shares, sellInVo.getPrice());
//        shares = BCNPUtils.calculation();

        Shares save = sharesRepository.save(shares);

    }

    private void saveAccountApart(List<SellOut> matchList, SellInVo sellInVo) {
        int number = matchList.size();
        //to account
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setAccountId(sellInVo.getAccountId());
        accountInfo.setSellCode(sellInVo.getCode());
        Example<AccountInfo> accountInfoExample = Example.of(accountInfo);
        AccountInfo accountInfoTemp = accountInfoRepository.findOne(accountInfoExample).orElse(null);
        if (accountInfoTemp != null) {
            int tempNumber = accountInfoTemp.getNumber();
            accountInfo.setNumber(tempNumber + number);
        } else {
            accountInfo.setNumber(number);
        }
        accountInfoRepository.save(accountInfo);

    }

    private void dealAll(List<SellOut> matchList, SellInVo sellInVo) {
    }

    private void dealApart(List<SellOut> matchList, SellInVo sellInVo) {
        int size = matchList.size();
        //out to 1
        List<SellOut> sellOutList = matchList.stream().map(vo -> {
            vo.setIsDelete("1");
            return vo;
        }).collect(Collectors.toList());

        List<SellOut> sellOutList1 = sellOutRepository.saveAll(sellOutList);

    }

    private void insertApart(List<SellOut> matchList, SellInVo sellInVo) {
        insertAll(matchList, sellInVo, sellInVo.getNumber() - matchList.size());
    }

    private void insertAll(List<SellOut> matchList, SellInVo sellInVo) {
        insertAll(matchList, sellInVo, sellInVo.getNumber());
    }

    private void insertAll(List<SellOut> matchList, SellInVo sellInVo, Integer number) {
        if (number == 0) {
            return;
        }
        if (number > 1000) {
            long start = System.currentTimeMillis();

            int n = number / 1000;

            ThreadPoolExecutor connetion = PoorThreadPool.getConnetion();

            for (int i = 0; i < n; i++) {
                final int tempI = i;
                connetion.execute(() -> {
                    ArrayList<SellIn> arrayList = new ArrayList<>();
                    for (int j = tempI * 1000; j < tempI * 1000 + 1000; j++) {
                        SellIn sellIn = new SellIn(null, sellInVo.getAccountId(), sellInVo.getCode(), sellInVo.getPrice(), sellInVo.getUpdateTime(), sellInVo.getIsDelete());

                        sellIn.setId(SnowFlakeGenerate.getId());
                        arrayList.add(sellIn);
                    }
                    sellInService.addBatch(arrayList);
                });
            }
            int number11 = number;
            connetion.execute(() -> {
                ArrayList<SellIn> arrayList = new ArrayList<>();
                for (int j = n * 1000; j < number11; j++) {
                    SellIn sellIn = new SellIn(null, sellInVo.getAccountId(), sellInVo.getCode(), sellInVo.getPrice(), sellInVo.getUpdateTime(), sellInVo.getIsDelete());
                    sellIn.setId(SnowFlakeGenerate.getId());
                    arrayList.add(sellIn);
                }
                sellInService.addBatch(arrayList);
            });
            connetion.shutdown();
            try {
                connetion.awaitTermination(300, TimeUnit.SECONDS);
                connetion.shutdownNow();
                long end = System.currentTimeMillis();
                System.out.println("一共：" + (end - start) + "ms");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } else {

            ArrayList<SellIn> arrayList = new ArrayList<>();
            for (int i = 0; i < number; i++) {
                SellIn sellIn = new SellIn(null, sellInVo.getAccountId(), sellInVo.getCode(), sellInVo.getPrice(), sellInVo.getUpdateTime(), sellInVo.getIsDelete());
                sellIn.setId(SnowFlakeGenerate.getId());
                arrayList.add(sellIn);
            }
            sellInService.addBatch(arrayList);
        }
    }


    @Override
    public void addBatch(List<SellIn> list) {
        int count = 0;
        for (SellIn sellIn : list) {
            count++;
            entityManager.persist(sellIn);//insert插入操作
            if (count % BATCH_SIZE == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
        entityManager.flush();
        entityManager.clear();
    }
}
