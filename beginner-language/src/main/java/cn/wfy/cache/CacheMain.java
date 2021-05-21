package cn.wfy.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis")
public class CacheMain {

    public static final String KEY = "testkey11111111";
    public static final String VALUE = "22222222222222222222";



    @Autowired
    private RedisUtil redisUtil;
    @RequestMapping("do")
    public void test(){
        for (int i = 0; i < 20; i++) {
            long start = System.currentTimeMillis();
            Object b = redisUtil.get(KEY);
//            System.out.println(b);
            redisUtil.set(KEY, VALUE);
            Object a = redisUtil.get(KEY);
//            System.out.println(a);
            long end = System.currentTimeMillis();
            System.out.println(end-start+" ms");
        }


    }
}
