package cn.wfy.speed;

import cn.wfy.lock.staticlock.PoorThreadPool;
import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

public class Alllock {

    static Map<String, Object> map = new ConcurrentHashMap();

    public static void main(String[] args) {
//        Alllock alllock = new Alllock();
//        ArrayList<Thread> arrayList = new ArrayList<>(1000);
//        IntStream.range(0, 100).forEach(u -> arrayList.add(new Thread(() -> {
//            IntStream.range(0, 1000).forEach(v -> {
//                alllock.aaab();
//                alllock.aaac();
//            });
//        })));
//        arrayList.forEach(Thread::start);
//

        ThreadPoolExecutor connetion = PoorThreadPool.getConnetion();
        ThreadPoolExecutor connetion1 = PoorThreadPool.getConnetion();
        Alllock alllock = new Alllock();
        for (int i = 0; i < 50; i++) {
            connetion.execute(new Runnable() {
                @Override
                public void run() {
                    alllock.aaac();
                }
            });

        }

        for (int i = 0; i < 50; i++) {
            connetion1.execute(new Runnable() {
                @Override
                public void run() {
                    alllock.aaab();
                }
            });

        }

        connetion.shutdown();
        connetion1.shutdown();
        try {
            connetion.awaitTermination(100, TimeUnit.SECONDS);
            connetion1.awaitTermination(100, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Set<String> strings = map.keySet();
        for (String string : strings) {
            System.out.println(string + "==" + map.get(string));
        }

        Long i = (Long) map.get("aaabb") - (Long) map.get("aaab");
        Long aa = (Long) map.get("aaacc") - (Long) map.get("aaac");
        System.out.println(i);
        System.out.println(aa);
    }


    private synchronized void aaac() {

        Object aaac = map.get("aaac");
        if (aaac == null) {
            map.put("aaac", System.currentTimeMillis());
        } else {
            long l = System.currentTimeMillis();
            if ((Long) aaac > l) {
                map.put("aaac", l);
            }
        }

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        for (int i = 0; i < 1000000; i++) {
            Object o = objectObjectHashMap.get(i);
            if (o != null && o.equals(i)) {
                objectObjectHashMap.put(i, i + (Integer) o);
            } else {
                objectObjectHashMap.put(i, i);
            }
        }

        Object aaacc = map.get("aaacc");
        if (aaacc == null) {
            map.put("aaacc", System.currentTimeMillis());
        } else {
            long l = System.currentTimeMillis();
            if ((Long) aaacc < l) {
                map.put("aaacc", l);
            }
        }
    }

    private void aaab() {
        Object aaab = map.get("aaab");
        if (aaab == null) {
            map.put("aaab", System.currentTimeMillis());
        } else {
            long l = System.currentTimeMillis();
            if ((Long) aaab > l) {
                map.put("aaab", l);
            }
        }
        ReadWriteLock lock = new ReentrantReadWriteLock();
        lock.writeLock().lock();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        for (int i = 0; i < 1000000; i++) {
            Object o = objectObjectHashMap.get(i);
            if (o != null && o.equals(i)) {
                objectObjectHashMap.put(i, i + (Integer) o);
            } else {
                objectObjectHashMap.put(i, i);
            }
        }
        lock.writeLock().unlock();
        Object aaabb = map.get("aaabb");
        if (aaabb == null) {
            map.put("aaabb", System.currentTimeMillis());
        } else {
            long l = System.currentTimeMillis();
            if ((Long) aaabb < l) {
                map.put("aaabb", l);
            }
        }
    }
}
