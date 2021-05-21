package cn.wfy.util;

import java.io.*;

public class SvnEmptyUtil {

    public static final String packageFile = ".keep";
    public static final String ignoreFile = "target";

//    public static void main(String[] args) {
////        isEmpty("E:\\code\\gitee\\beginner");
//        isEmpty("D:\\workspace\\myweb\\mygithub\\beginner");
//    }

    public static void isEmpty(String fileName) {
        File file = new File(fileName);
        isEmpty(file);
    }

    public static void isEmpty(File file) {
        File[] files = file.listFiles();
        if (files.length == 0) {
            if (!file.getPath().contains(ignoreFile)) {
                FileUtils.createFile(file.getAbsolutePath() + "/" + packageFile);
            }
        }
        for (File f : files) {
            if (f.isDirectory()) {
                isEmpty(f);
            }
        }
    }

}
