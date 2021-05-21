package cn.wfy.斐波那契数列;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/4/4
 */
public class Solution {
    static final int number = 4000_000;
    static long[] methodArray;
    static long[] array;

    public static void main(String[] args) {
        Solution solution = new Solution();

        methodArray = new long[number + 2];
        array = new long[(number + 1)];

        long startTime = System.currentTimeMillis();
//        Long fun = solution.method1(number);
//        System.out.println(fun);
        long endTime = System.currentTimeMillis();
        System.out.println("method1花费了：" + (endTime - startTime) + "ms");
        System.gc();

        long startTime1 = System.currentTimeMillis();
        Long fun1 = solution.method2(number);
        System.out.println(fun1);
        long endTime1 = System.currentTimeMillis();
        System.out.println("method2花费了：" + (endTime1 - startTime1) + "ms");
        System.gc();

        long startTime2 = System.currentTimeMillis();
        Long fun2 = solution.method3(number);
        System.out.println(fun2);
        long endTime2 = System.currentTimeMillis();
        System.out.println("method3花费了：" + (endTime2 - startTime2) + "ms");
        System.gc();


    }

    private long method1(int number) {
        if (number == 1 || number == 2) {
            return 1;
        } else {
            return method1(number - 1) + method1(number - 2);
        }
    }


    private long method2(int number) {
        long value;
        if (number == 1 || number == 2) {
            value = 1;
        } else {
            if (array[number] != 0) {
                value = array[number];
            } else {
                value = method2(number - 1) + method2(number - 2);
                array[number] = value;
            }
        }
        return value;

    }


    private long method3(int number) {
        if (number == 1 || number == 2) {
            return 1;
        }
        methodArray[1] = 1;
        methodArray[2] = 1;
        for (int i = 3; i < methodArray.length; i++) {
            methodArray[i] = methodArray[i - 1] + methodArray[i - 2];
        }
        return methodArray[number];

    }
}
