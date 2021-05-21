package cn.wfy.其他.工作流.flow.test;

import cn.wfy.其他.工作流.flow.old.Domain;

public class MainTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Domain domain = new Domain();
        domain.createData();
        long end = System.currentTimeMillis();
        //15_092ms == ole method
        System.out.println(end - start + "ms == ole method");

    }
}
