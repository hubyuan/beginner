package cn.wfy.map;

import java.util.*;

public class CurrentMap {
    static Map cylist;

    public static void main(String[] args) {
        cylist = Collections.synchronizedMap(new HashMap());
//        cylist =new HashMap();


        for (int i = 0; i < 100; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {

                        cylist.put(j + "a " + this.getName(), "");
                    }
//                    cylist.put("b"+this.getName(), "bbb"+this.getName());
//                    cylist.put("c"+this.getName(), "ccc"+this.getName());

                }
            }.start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cylist);
        System.out.println(cylist.size());

    }
}
