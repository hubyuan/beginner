package cn.wfy.impl;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TestTImpl extends Example {
    public static void main(String[] args) {


        List<String> of = ImmutableList.of("aa", "dd");


        ArrayList<String> strings = Lists.newArrayList("12", "33");

//        List<String> list = Arrays.asList("dd", "3");
//        System.out.println(list);
//        list.add("34");
//        System.out.println(list);
        strings.add("323");
        System.out.println(strings);
    }
}
