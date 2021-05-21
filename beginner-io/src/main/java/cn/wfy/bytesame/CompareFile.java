package cn.wfy.bytesame;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;

/***
 * 只支持小文件
 * 大文件可以使用md5验证
 * md5就是全损压缩
 */
public class CompareFile {

    public void comp(File file) throws FileNotFoundException {
        //file等级判断
        System.out.println(file.getName());
        long totalSpace = file.getTotalSpace();
        long usableSpace = file.getUsableSpace();
        long freeSpace = file.getFreeSpace();

        long length = file.length();
        System.out.println(length);

        //byte等级判断

    }

    public static void main(String[] args) throws IOException {
        CompareFile compareFile = new CompareFile();
        File file = new File("E:\\code\\gitee\\beginner\\beginner\\beginner-io\\src\\main\\resources\\file\\do.txt");
        File file1 = new File("E:\\code\\gitee\\beginner\\beginner\\beginner-io\\src\\main\\resources\\file\\do1.txt");
//        compareFile.comp(new File("E:\\code\\gitee\\beginner\\beginner\\beginner-io\\src\\main\\resources\\file\\test.txt"));
//        compareFile.comp(new File("E:\\code\\gitee\\beginner\\beginner\\beginner-io\\src\\main\\resources\\file\\test1.txt"));

        Byte[] aa = new Byte[1024];
        byte[] ee = new byte[561];
        for (int i = 0; i < ee.length; i++) {
            byte b = ee[i];
            System.out.println(b);
        }
//        compareFile.compByFile(file, file1);
    }

    public void compByFile(File src, File dest) throws IOException {
        //file等级判断

        long src_length = src.length();
        long dest_length = dest.length();
        System.out.println(src_length / 1024 / 1024);
        System.out.println(dest_length / 1024 / 1024);
        if (src_length != dest_length) {
            return;


        }

        //byte等级判断
        InputStream src_in = new FileInputStream(src);
        InputStream dest_in = new FileInputStream(dest);


        byte[] src_byte = new byte[src_in.available()];
        byte[] dest_byte = new byte[dest_in.available()];
        System.out.println(src_byte);


        long a = System.currentTimeMillis();
        for (int i = 0; i < src_byte.length; i++) {
            if (src_byte[i] == dest_byte[i]) {

            } else {
                break;
            }
        }
        long b = System.currentTimeMillis();
        System.out.println("字节对比: " + (b - a));

        long l = System.currentTimeMillis();
        String ss = DigestUtils.md5Hex(src_byte);
        String s = DigestUtils.md5Hex(dest_byte);

        long ll = System.currentTimeMillis();
        System.out.println("md5: " + (ll - l));
        System.out.println(ss);
        System.out.println(s);


    }


}
