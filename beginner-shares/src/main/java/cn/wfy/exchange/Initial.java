package cn.wfy.exchange;

import cn.wfy.entity.SellOut;
import cn.wfy.entity.Shares;
import cn.wfy.service.ShareService;
import cn.wfy.utils.SnowFlakeGenerate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/26
 */
@Order(100000)
public class Initial implements CommandLineRunner {

    @Resource
    private ShareService shareService;


    @Override
    public void run(String... args) throws Exception {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Initial initial = new Initial();
            initial.initial();
        }).start();

    }

    private EntityManager entityManager;

    @Transactional(rollbackFor = Exception.class)
    public void addBatch(List<SellOut> list) {
        for (SellOut sellOut : list) {
            entityManager.persist(sellOut);//insert插入操作
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

    public void initial() {

        for (int i = 0; i < 10; i++) {
            char charStr = 'a';
            Shares shares = new Shares();
            shares.setCode(10000 + i);
            shares.setName("虚拟" + (char) (charStr + i) + "股");
            double randomPrice = getRandomPrice();
            shares.setBp(randomPrice);
            shares.setCp(randomPrice);
            shares.setSp(randomPrice);
            shareService.insert(shares);
            Integer randomNumber = getRandomNumber();
            ArrayList<SellOut> arrayList = new ArrayList<>();
            for (Integer stockSum = 0; stockSum < randomNumber; stockSum++) {
                SellOut sellOut = new SellOut(SnowFlakeGenerate.getId(), 0L, 10000 + i, randomPrice, new Date(), "0");
                arrayList.add(sellOut);
            }
            this.addBatch(arrayList);
        }
    }


    public static void main(String[] args) {
        Initial initial = new Initial();
        initial.initial();


    }

    //0~99
    public double getRandomPrice() {
        Random random = new Random();
        double v = (random.nextDouble() * 10) * (random.nextDouble() * 10);
        BigDecimal bigDecimal = new BigDecimal(v);
        return bigDecimal.setScale(2, RoundingMode.CEILING).doubleValue();
    }

    //100 ~ 100_000
    public Integer getRandomNumber() {
        Random random = new Random();
        Integer number = (random.nextInt(10) + 1) * (random.nextInt(10) + 1) * (random.nextInt(10) + 1) * 100;
        return number;
    }
}
