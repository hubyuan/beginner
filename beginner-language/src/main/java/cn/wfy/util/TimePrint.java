package cn.wfy.util;

public class TimePrint {
    private static Long one = null;
    private static Long two = null;

    public static void tag() {
        if (one == null) {
            one = System.currentTimeMillis();
        } else {
            if (two != null) {
                one = two;
            }
            two = System.currentTimeMillis();
        }
        if (two != null) {
            System.out.println(two - one + "ms");
        }
    }
}
