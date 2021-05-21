package cn.wfy.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Objects;
import java.util.stream.IntStream;

import static java.lang.Float.NaN;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/2/16
 */
public class MapTest {
    static int count = 0;

    public static void main(String[] args) {
        System.out.println(1);
        HashMap<Object, Object> hashMap = new HashMap<>(15, 2);
        System.out.println(1);

    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : n + 1;
    }
}
