package cn.wfy.others;

import java.lang.annotation.Documented;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/10
 */
public class ClassificationTest {
    public static void main(String[] args) {
        double[] arr = {1.0, 2.0, 3.0};
        int m = 5;
        System.out.println(c(arr, 5));
    }

    public static int c(double[] arr, int m) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int mod = (arr.length - 1) & m;
            count = count > mod ? count : mod;
        }
        return count;
    }

    //Return value of b(String) ignored, but method has no side effect
    public static int a(String str) {
        char[] chars = str.toCharArray();
        int count = 0;
        boolean[] chars1 = new boolean[26];
        for (int i = 0; i < chars.length; i++) {
            chars1[chars[i] - 'a'] = true;
        }
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] == true) {
                count++;
            }
        }
        return count;
    }

    public static int b(String[] strList) {
        int a = 0;
        for (String str : strList) {
            char[] chars = str.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                a |= 1 << (chars[i] - 'a');
            }
        }
        int count = 0;
        while (a > 0) {
            if (a % 2 == 1) {
                count++;
            }
            a = a >> 1;
        }
        return count;
    }
}
