package cn.wfy.面试;

import com.mysql.cj.util.TimeUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/9/14
 */
public class 一碑 {
    public static void main(String[] args) throws IOException {

        Calendar instance = Calendar.getInstance();
//        File file = new File("");
//        FileInputStream fileInputStream = new FileInputStream(file);

        //thread runnable callable
        Thread thread = new Thread();
        new Runnable() {
            @Override
            public void run() {

            }
        };

        new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return null;
            }
        };
        一碑 yibei = new 一碑();
        yibei.aaa();

    }

    public synchronized void aaa(){
        ReentrantLock lock = new ReentrantLock();
//        LinkedHashSet<Object> hashSet = new LinkedHashSet<>();
        LinkedHashSet<Object> hashSet = new LinkedHashSet<>();
        for (int i = 20; i > 0 ; i--) {
            hashSet.add(i);
        }


        Iterator it1 = hashSet.iterator();
        while (it1.hasNext()) {
            System.out.println(it1.next());
        }


    }

}
