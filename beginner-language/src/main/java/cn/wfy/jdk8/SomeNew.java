package cn.wfy.jdk8;

import cn.wfy.vo.TestVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SomeNew {
    public static void main(String[] args) {
        optional();
    }

    private static void optional() {
        TestVo testVo = new TestVo();
        List<TestVo> list = null;
        boolean equals = Optional.of(list).equals(null);
        System.out.println(equals);
    }
}
