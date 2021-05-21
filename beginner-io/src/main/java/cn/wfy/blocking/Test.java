package cn.wfy.blocking;

import java.io.IOException;
import java.util.Random;

public class Test {

    //测试主方法
    public static void main(String[] args) throws InterruptedException {


        startBlokingTest();

    }

    private static void startBlokingTest() throws InterruptedException {
        //运行服务器
        new Thread(new Runnable() {
            @Override
            public void run() {
                //                    Server.start();
            }
        }).start();
        //避免客户端先于服务器启动前执行代码
        Thread.sleep(2000);
        //运行客户端
        new Thread(new Runnable() {
            @SuppressWarnings("static-access")
            @Override
            public void run() {
                Client.send("hhh");
            }
        }).start();

    }

}
