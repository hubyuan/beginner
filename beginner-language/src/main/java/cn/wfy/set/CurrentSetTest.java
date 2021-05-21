package cn.wfy.set;

import cn.wfy.util.Binary;
import cn.wfy.util.TimePrint;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class CurrentSetTest {

    public static void main(String[] args) {
        Set countDataSet = null;

        TimePrint.tag();
        normal(countDataSet);
        TimePrint.tag();
        sercurty(countDataSet);
        TimePrint.tag();
    }

    private static void sercurty(Set countDataSet) {
        countDataSet = Collections.synchronizedSet(new HashSet<>());
        for (int i = 0; i < Binary.seven; i++) {
            countDataSet.add(i);
        }

    }

    private static void normal(Set countDataSet) {
        countDataSet = new ConcurrentSkipListSet<>();
        for (int i = 0; i < Binary.seven; i++) {
            countDataSet.add(i);
        }
    }

}
