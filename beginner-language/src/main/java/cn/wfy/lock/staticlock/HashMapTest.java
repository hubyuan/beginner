package cn.wfy.lock.staticlock;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class HashMapTest {
    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger();

        Map map = new ConcurrentHashMap();
        Object put = map.put("1", "2");
        Object o = map.putIfAbsent("1", "3");
        System.out.println(map);
        HashMap hashMap = new HashMap();
//        hashMap.put()
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("", "");
    }
}
