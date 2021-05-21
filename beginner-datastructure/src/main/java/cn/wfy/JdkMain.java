package cn.wfy;

import java.util.ArrayList;

public class JdkMain {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();

        System.out.println(objects.toString());
        Object o = objects.get(5);
        System.out.println(o);
    }

}
