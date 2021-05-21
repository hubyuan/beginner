package cn.wfy.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/28
 */
public class MathUtils {
    //0~99
    public static double getRandomPrice() {
        Random random = new Random();
        double v = (random.nextDouble() * 10) * (random.nextDouble() * 10);
        BigDecimal bigDecimal = new BigDecimal(v);
        return bigDecimal.setScale(2, RoundingMode.CEILING).doubleValue();
    }

    //100 ~ 100_000
    public static Integer getRandomNumber() {
        Random random = new Random();
        Integer number = (random.nextInt(10) + 1) * (random.nextInt(10) + 1) * (random.nextInt(10) + 1) * 100;
        return number;
    }
}
