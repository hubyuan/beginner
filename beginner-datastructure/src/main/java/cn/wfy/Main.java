package cn.wfy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(12312);
        System.out.println(list.hashCode());
        List<Object> objects = Collections.synchronizedList(list);
        System.out.println(objects.hashCode());
        System.out.println(list.hashCode());

    }
}
