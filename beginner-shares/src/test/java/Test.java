import cn.wfy.entity.SellIn;
import cn.wfy.entity.SellInVo;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/29
 */
public class Test {
    public static void main(String[] args) {
/*        SellInVo sellInVo = new SellInVo(null, 1L, 10001, 10, new Date(), "0", 1000);

        long l = System.currentTimeMillis();
        ArrayList<SellIn> arrayList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            SellIn sellIn = new SellIn(null, sellInVo.getAccountId(), sellInVo.getCode(), sellInVo.getPrice(), sellInVo.getUpdateTime(), sellInVo.getIsDelete());
            sellIn.setId(Long.valueOf(i));
            arrayList.add(sellIn);
        }
*//*
        //1467
        for (int i = 0; i < 1000000; i++) {
            SellIn sellIn = new SellIn();
            BeanUtils.copyProperties(sellInVo, sellIn);
            sellIn.setId(Long.valueOf(i));
            arrayList.add(sellIn);
        }
        *//*

        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);*/

        ArrayList<Object> arrayList = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            arrayList.add(String.valueOf(i));
        }

        Iterator<Object> iterator = arrayList.iterator();


        for (Object o : arrayList) {
            if ("2".equals(o)){
                arrayList.remove(o);
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            boolean equals = arrayList.get(i).equals("2");
            if (equals){
                arrayList.remove(arrayList.get(i));
            }
        }
        System.out.println(arrayList.size());
    }
}
