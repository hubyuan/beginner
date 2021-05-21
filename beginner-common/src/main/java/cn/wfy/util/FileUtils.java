package cn.wfy.util;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static boolean createFile(String destFileName) {
        return createFile(new File(destFileName));
    }

    public static boolean createFile(File destFile) {
        if (destFile.exists()) {
            return false;
        }
        //判断目标文件所在的目录是否存在
        if (!destFile.getParentFile().exists()) {
            destFile.mkdirs();
        }
        //创建目标文件
        try {
            if (destFile.createNewFile()) {
                System.out.println(destFile.getAbsoluteFile());
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
