package cn.wfy.id;

import cn.wfy.util.TimePrint;

public class IdTest {
    public static void main(String[] args) {
        //相差10倍
        Long size = 10000000l;
        //单机单线程情况
        TimePrint.tag();
        for (Long i = 0l; i < size; i++) {
            snow();
        }
        TimePrint.tag();

        for (Long i = 0l; i < size; i++) {
            idgenerate();
        }
        TimePrint.tag();


    }

    private static void idgenerate() {
        long l = IdCreator.generateId();
    }

    private static void snow() {
        SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(1, 2);
        long l = snowflakeIdWorker.nextId();
    }
}
