package cn.wfy;

import cn.wfy.util.PoorThreadPool;

import java.util.concurrent.ThreadPoolExecutor;

public class ThreadMain {
    public static void main(String[] args) {

        ThreadPoolExecutor connetion = PoorThreadPool.getConnetion();

        for (int i = 0; i < 3; i++) {
            connetion.execute(new Runnable() {
                @Override
                public void run() {
                    startIt();
                }
            });
        }


        connetion.shutdown();



    }

    private static void startIt() {
        for (int i = 0; i < 10; i++) {
            MyArrayList<Object> myArrayList = new MyArrayList<>();
            myArrayList.add(i);
            System.out.println(myArrayList.hashCode()+ myArrayList.toString());
        }

    }
}
