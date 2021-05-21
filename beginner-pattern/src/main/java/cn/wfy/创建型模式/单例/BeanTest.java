package cn.wfy.创建型模式.单例;

import java.util.ArrayList;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/4/10
 */
public class BeanTest {
    private ArrayList<Object> arrayList = new ArrayList<>();

    public void aaa(String a) {
        boolean add = arrayList.add(a);
        if (!add) {
            System.out.println(add);
        }
    }
}
