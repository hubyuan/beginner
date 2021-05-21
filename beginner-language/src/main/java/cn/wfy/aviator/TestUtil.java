package cn.wfy.aviator;

import com.googlecode.aviator.annotation.Function;

public class TestUtil {
    @Function(rename = "excute1")
    public static int test1(String str) {
        System.out.println("execute test1:" + str);
        return 1;
    }

    public static int test2(String str) {
        System.out.println("execute test2:" + str);
        return 2;
    }

    public static int test3(String str) {
        System.out.println("execute test3:" + str);
        return 3;
    }
}
