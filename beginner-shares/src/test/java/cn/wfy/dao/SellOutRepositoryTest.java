package cn.wfy.dao;

import cn.wfy.entity.SellOut;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/4/11
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SellOutRepositoryTest {

    @Autowired
    private SellOutRepository sellOutRepository;

    @Test
    public void isMatch() {
        List<SellOut> match = sellOutRepository.isMatch(10000, 200d, 100);
        System.out.println(match.size());
        match.forEach(System.out::println);
    }

    @Test
    public void findOutAll() {
        List<SellOut> outAll = sellOutRepository.findOutAll1(100);
        System.out.println(outAll.size());
    }
}