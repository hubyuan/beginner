package cn.wfy.id;

import org.springframework.beans.factory.annotation.Value;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

public class IdCreator {
    private static AtomicInteger s_counter = new AtomicInteger(0);
    @Value("${system.code}")
    static int m_groupId;

    //组id, 最大值为512, 超过将被截取
    public IdCreator(int groupId) {
        m_groupId = groupId & 512;
    }

    //每1.95ms最多生成8191个数
    public static long generateId() {
        Calendar now = Calendar.getInstance();

        long v = m_groupId; //9 bits, 组id
        v <<= 9;
        v |= now.get(Calendar.MILLISECOND) & 511;   //9 bits, 1.95MS
        v <<= 6;
        v |= now.get(Calendar.SECOND);   //6 bits
        v <<= 6;
        v |= now.get(Calendar.MINUTE);   //6 bits
        v <<= 5;
        v |= now.get(Calendar.HOUR);     //5 bits
        v <<= 5;
        v |= now.get(Calendar.DAY_OF_MONTH);   //5 bits
        v <<= 4;
        v |= now.get(Calendar.MONTH);   //4 bits
        v <<= 6;
        v |= now.get(Calendar.YEAR) & 63;    //最大63年  6 bits
        v <<= 15;
        v |= s_counter.getAndAdd(1) & 8191;  //13 bits

        return v;
    }

    public static void main(String[] args) {
        IdCreator c = new IdCreator(41);
        System.out.println("the new Id is:" + c.generateId());
    }
}
