package cn.wfy.util;


import java.io.File;

public class GetFileName {
    static String fileName = "E:\\project\\qzf\\rwrfl\\qzf";

//    public static void main(String[] args) {
//        for (int i = 0; i < 15; i++) {
//            System.out.println("nohup java -jar $APP_NAME" + i + "/$APP_NAME" + i + ".jar > $APP_NAME" + i + "/nohup.out 2>&1 & ");
//            System.out.println("sleep 3");
//        }
////        getFileName1(fileName);
//    }

    private static void getFileName1(String fileName) {
        File file = new File(fileName);
        File[] files = file.listFiles();
        Integer count = 1;
        for (File f : files) {
            if (f.isDirectory()) {

                System.out.println("APP_NAME" + count++ + "=" + f.getName());
            }
        }

    }
}
