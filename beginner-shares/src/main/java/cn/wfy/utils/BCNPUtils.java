package cn.wfy.utils;

import cn.wfy.entity.Shares;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/4/11
 */
public class BCNPUtils {
    public static Shares calculation(Shares shares, double nowPrice) {
        double np = shares.getNp();
        shares.setBp(nowPrice);
        shares.setCp(np);
        shares.setNp(getMiddleNumber(shares.getBp(), shares.getCp(), shares.getSp()));
        return shares;
    }


    private static double getMiddleNumber(double a, double b, double c) {
        return a > b ? (b > c ? b : c) : (a > c ? a : c);
    }
}
