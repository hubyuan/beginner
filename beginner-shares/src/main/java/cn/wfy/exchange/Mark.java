package cn.wfy.exchange;


import cn.wfy.dao.SellInRepository;
import cn.wfy.dao.SellOutRepository;
import cn.wfy.entity.SellIn;
import cn.wfy.entity.SellOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/27
 */
@Component
public class Mark implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        startMark();


    }

    private void startMark() {
        List<SellIn> sellIn = getSellIn(null);

        List<SellOut> sellOut = getSellOut(null);

        //计算 ps es


        System.out.println(sellIn.size());
        System.out.println(sellOut.size());
    }

    @Autowired
    private SellInRepository sellInRepository;
    @Autowired
    private SellOutRepository sellOutRepository;

    public void buyStock(int code, double price, Date time) {

    }

    public List<SellIn> getSellIn(Integer code) {
        return sellInRepository.findInAll();
    }

    public List<SellOut> getSellOut(Integer code) {
        return sellOutRepository.findOutAll();
    }
}
