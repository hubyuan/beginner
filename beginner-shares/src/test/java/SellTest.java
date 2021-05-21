/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/27
 */

import cn.wfy.dao.SharesRepository;
import cn.wfy.entity.SellIn;
import cn.wfy.entity.SellInVo;
import cn.wfy.entity.Shares;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellTest {


    @Test
    public void testAdd() {
        SellInVo sellInVo = new SellInVo(null, 1L, 10001, 10, new Date(), "0", 1000);

        long l = System.currentTimeMillis();
        ArrayList<SellIn> arrayList = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            SellIn sellIn = new SellIn();
            BeanUtils.copyProperties(sellInVo, sellIn);
            sellIn.setId(Long.valueOf(i));
            arrayList.add(sellIn);
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);

    }


}
