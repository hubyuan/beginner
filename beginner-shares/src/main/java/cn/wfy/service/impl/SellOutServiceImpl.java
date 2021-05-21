package cn.wfy.service.impl;

import cn.wfy.dao.SellOutRepository;
import cn.wfy.entity.SellOut;
import cn.wfy.entity.Shares;
import cn.wfy.utils.SnowFlakeGenerate;
import cn.wfy.service.SellOutService;
import cn.wfy.service.ShareService;
import cn.wfy.utils.MathUtils;
import cn.wfy.utils.PoorThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/28
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SellOutServiceImpl implements SellOutService {

    private final int BATCH_SIZE = 500;
    @Autowired
    private SellOutRepository sellOutRepository;

    @Autowired
    private ShareService shareService;

    @Autowired
    private SellOutService sellOutService;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addBatch(List<SellOut> list) {
        int count = 0;
        for (SellOut sellOut : list) {
            count++;
            entityManager.persist(sellOut);//insert插入操作
            if (count % BATCH_SIZE == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
        entityManager.flush();
        entityManager.clear();
    }

    @Transactional(rollbackFor = Exception.class)
    public void addBatch1(Shares shares) {
        entityManager.persist(shares);//insert插入操作
        entityManager.flush();
        entityManager.clear();
    }


    //初始化
    @Override
    @Transactional
    public void initial() {
        long start = System.currentTimeMillis();
        ThreadPoolExecutor connetion = PoorThreadPool.getConnetion();

        for (int i = 0; i < 10; i++) {
            final int tempI = i;
            connetion.execute(() -> {
                char charStr = 'a';
                Shares shares = new Shares();
                shares.setCode(10000 + tempI);
                shares.setName("虚拟" + (char) (charStr + tempI) + "股");
                double randomPrice = MathUtils.getRandomPrice();
                shares.setBp(randomPrice);
                shares.setCp(randomPrice);
                shares.setSp(randomPrice);
                shares.setNp(randomPrice);
                shareService.insert(shares);
                Integer randomNumber = MathUtils.getRandomNumber();
                ArrayList<SellOut> arrayList = new ArrayList<>();


                for (Integer stockSum = 0; stockSum < randomNumber; stockSum++) {
                    SellOut sellOut = new SellOut(SnowFlakeGenerate.getId(), 0L, 10000 + tempI, randomPrice, new Date(), "0");
                    arrayList.add(sellOut);
                }
                sellOutService.addBatch(arrayList);
            });
        }

        connetion.shutdown();
        try {
            connetion.awaitTermination(300, TimeUnit.SECONDS);
            connetion.shutdownNow();
            long end = System.currentTimeMillis();
            System.out.println("一共：" + (end - start) + "ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int testnum(int num) {
        return num * num;
    }
}
