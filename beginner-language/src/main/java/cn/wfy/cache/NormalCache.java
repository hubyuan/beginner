package cn.wfy.cache;

import cn.wfy.vo.ApiResponse;

import java.util.concurrent.ConcurrentHashMap;

public class NormalCache {
    public static void main(String[] args) {
        String key = "31231";
        ApiResponse value = ApiResponse.ofSuccess("he");
        put(key,value);
        Object o = get(key);
        ApiResponse o1 = (ApiResponse) o;
        System.out.println(o1.getMsg());
    }

    private static ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();

    public static void put(Object key, Object value) {
        concurrentHashMap.put(key, value);
    }

    public static Object get(Object key) {
        return concurrentHashMap.get(key);
    }

}
