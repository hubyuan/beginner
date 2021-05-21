package cn.wfy.宝石与石头;

import java.util.Random;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/4/4
 */
public class Solution {

    static char[] a = {'u', 'e', 'w', 'p', 'i', 'z'};
    static char[] b = {'a', 'A', 'A', 'A', 'B', 'b'};

    public static void main(String[] args) {
        Solution solution = new Solution();
        int lenth = 1000_000_0;
        char[] b1 = new char[lenth + 1];
        for (int i = 0; i < lenth + 1; i++) {
            char c = (char) ('a' + new Random().nextInt(20));
            if (c - 'a' < 0) {
                System.out.println(c + "=====");
            }
            b1[i] = c;
        }


        long startTime = System.currentTimeMillis();
        System.out.println(solution.method1(a, b1));
        long endTime = System.currentTimeMillis();
        System.out.println("method1花费了：" + (endTime - startTime) + "ms");
        System.gc();
        long startTime1 = System.currentTimeMillis();
        System.out.println(solution.method2(a, b1));
        long endTime1 = System.currentTimeMillis();
        System.out.println("method1花费了：" + (endTime1 - startTime1) + "ms");
        System.gc();

    }

    private int method1(char[] j, char[] s) {
        int count = 0;
        for (int i = 0; i < j.length; i++) {
            for (int k = 0; k < s.length; k++) {
                if (s[k] == j[i]) {
                    count++;
                }
            }
        }
        return count;
    }


    private int method2(char[] j, char[] s) {
        int[] cc = new int[100];
        int count = 0;
        for (int k = 0; k < s.length; k++) {
            cc[s[k] - 'a'] += 1;
        }
        for (int i = 0; i < j.length; i++) {
            count += cc[j[i] - 'a'];
        }
        return count;
    }

}
