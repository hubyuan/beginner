package cn.wfy.map;

import java.util.Date;
import java.util.HashMap;

public class MapTest {
    public static void main(String[] args) {
//        maptest();
//        testHash();
        System.out.println(testCap(1/2));

    }

    private static void testHash() {

        HashMap<Object, Object> hashMap = new HashMap<>(2, 1.1f);
        for (int i = 0; i < 10000; i++) {
            hashMap.put(i, i);
        }
        System.out.println(hashMap);
    }

    static final int MAXIMUM_CAPACITY = 1 << 30;

    private static int testCap(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    private static void maptest() {

        IkMap ikMap = new IkMap();
        ikMap.put("a", "bb");
        Object a = ikMap.get("a");
        System.out.println(a);
        HashMap hashMap = new HashMap();
        Object put = hashMap.put("hh", "mm");
        Object hh = hashMap.get("hh");
        System.out.println(hh);
    }
}
