package cn.wfy.创建型模式.单例;

import cn.wfy.util.SpringContextUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.IntStream;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/4/10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTest {
    public static void main(String[] args) {


    }

    public void bbb(){
        BeanTest bean1 = SpringContextUtils.getBean(BeanTest.class);
        bean1.aaa("adf");
        IntStream.range(0, 1).forEach(vo -> {

            new Thread(() -> {
                BeanTest bean = SpringContextUtils.getBean(BeanTest.class);
                bean.aaa(String.valueOf(vo));
                System.out.println(Thread.currentThread().getName());
            }, String.valueOf(vo)).start();

        });
    }

    @Test
    public void test1(){
        System.out.println("112");
    }
}
