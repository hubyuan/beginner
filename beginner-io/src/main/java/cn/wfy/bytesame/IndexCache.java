package cn.wfy.bytesame;

import java.util.HashMap;

public class IndexCache {

    static HashMap<String, Object> indexMap;

    public IndexCache() {
        indexMap = new HashMap<>();
    }

    public static void getIndex(String key) {
        indexMap.get(key);
    }

    public static void putIndex(String key, Object value) {
        indexMap.put(key, value);

    }
}
