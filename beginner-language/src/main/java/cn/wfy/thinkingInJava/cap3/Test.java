package cn.wfy.thinkingInJava.cap3;

import java.util.Date;
import java.util.Random;

/**
 * @Description TODO
 * @auther wfy
 * @since 2020/7/8
 */
public class Test {
    public static void main(String[] args) {
        Random random = new Random(1);
        Random random1 = new Random(1);
        int i1 = random.nextInt();
        int i2 = random1.nextInt();
        System.out.println(i1);
        System.out.println(i2);

        double distance = 0;
        double time = 0;

        int ii = 0x2f;
        System.out.println(Integer.toBinaryString(ii));

        double kk = 12e-3d;
        System.out.println(kk);
        //| & ! ^
        int a = 2;
        int b = 4;
        a = a ^ b;
        b = a ^ b;
        System.out.println(a ^ b);
        System.out.println(b);

        int c = 2;
        int d = 4;
        c = c << 10;
        c = c + d;
        d = c >> 10;
        c = c + d >> 10;
        System.out.println(c);
        System.out.println(d);


    }
}
