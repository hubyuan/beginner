package cn.wfy.单例;

import cn.wfy.创建型模式.单例.SpringTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/4/10
 */
@SpringBootTest
public class BeanTestTest {


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void aaa() {
        Assert.assertEquals("1","1");
        SpringTest springTest = new SpringTest();
        springTest.bbb();
    }
}