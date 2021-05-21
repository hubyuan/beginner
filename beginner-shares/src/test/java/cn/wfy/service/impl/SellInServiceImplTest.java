package cn.wfy.service.impl;

import cn.wfy.entity.SellInVo;
import cn.wfy.service.SellInService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/4/11
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SellInServiceImplTest {

    @Autowired
    private SellInService sellInService;
    @Test
    public void releaseShares() {
        SellInVo sellInVo = new SellInVo();
        sellInVo.setAccountId(578711892093177856L);
        sellInVo.setCode(10000);
        sellInVo.setNumber(100);
        sellInVo.setPrice(56.28);//47.28
        sellInVo.setUpdateTime(new Date());
        sellInService.releaseShares(sellInVo);
    }
}