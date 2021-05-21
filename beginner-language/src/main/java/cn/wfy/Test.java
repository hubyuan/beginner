package cn.wfy;


import cn.wfy.lock.staticlock.HashMapTest;
import cn.wfy.lock.staticlock.PoorThreadPool;
import cn.wfy.vo.TestVo;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

/***
 *
 * TREEIFY_THRESHOLD
 * threshold
 */
public class Test {
    public static String getHour(Date time) {
        Calendar c = Calendar.getInstance();    //获取Calendar类的实例
        c.setTime(time);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        return String.valueOf(hour);
    }

    public static String getDay(Date time) {
        Calendar c = Calendar.getInstance();    //获取Calendar类的实例
        c.setTime(time);
        int hour = c.get(Calendar.DAY_OF_MONTH);
        return String.valueOf(hour);
    }

    public static String getMon(@NotNull Date time) {
        Calendar c = Calendar.getInstance();    //获取Calendar类的实例
        c.setTime(time);
        int hour = c.get(Calendar.MONTH) + 1;
        return String.valueOf(hour);
    }


    //获取明天凌晨时间
    public static String getTomorrow0AMToString() {
        return null;
    }

    private static Date getTomorrow0AM() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        Date date = new Date(calendar.getTimeInMillis());
        if (date.after(new Date())) {
            date = new Date();
        }
        return date;
    }

    final static Integer number = 1000000;

    public static void main(String[] args) throws Exception {

        ArrayList arrayList = new ArrayList();
        arrayList.add("a");
        arrayList.add("a1");
        arrayList.add("a2");
        arrayList.add("a3");
        arrayList.add("a4");
        for (Object o : arrayList) {
            arrayList.remove(0);
        }



    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= (1 << 30)) ? (1 << 30) : n + 1;
    }

    private static void list11() {
        ArrayList<Object> arrayList = new ArrayList<>();
        LinkedList<Object> linkedList = new LinkedList<>();


        long a = System.currentTimeMillis();
        for (int i = 0; i < number / 2; i++) {
            arrayList.add(0, i);
        }
        long b = System.currentTimeMillis();
        System.out.println("arrayList " + (b - a) + " ms");
        long a1 = System.currentTimeMillis();
        for (int i = 0; i < number / 2; i++) {
            linkedList.add(0, i);
        }
        long b1 = System.currentTimeMillis();
        System.out.println("linkedList " + (b1 - a1) + " ms");
//        arrayList.indexOf()
        Iterator<Object> iterator = linkedList.iterator();
    }

    static JSONObject jsonObject = new JSONObject();

    public void aaa() {

        ArrayList<Thread> arrayList = new ArrayList<>(1000);
        IntStream.range(0, 10).forEach(u -> arrayList.add(new Thread(() -> {
            IntStream.range(0, 10).forEach(v -> {
                eee();
            });
        })));
        arrayList.forEach(Thread::start);
        System.out.println(jsonObject);

    }

    private void eee() {
        jsonObject.put(Thread.currentThread().getName(), 123);

    }

    public void aa(int a) {
    }

    private void aa(int a, int b) {
    }

    //获取本月第一天，返回值string类型
    public static String getMonth0DayToString() {
        return null;
    }


    //获取本月第一天
    public static Date getMonth0Day() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + 1);

        return new Date(calendar.getTimeInMillis());
    }


    private static String removeZero1(BigDecimal val) {
        String format = val.toString();
//        if (format.indexOf(".") > 0) {
//            //正则表达
//            format = format.replaceAll("0+?$", "");//去掉后面无用的零
//            format = format.replaceAll("[.]$", "");//如小数点后面全是零则去掉小数点
//        }
        return format;
    }

}