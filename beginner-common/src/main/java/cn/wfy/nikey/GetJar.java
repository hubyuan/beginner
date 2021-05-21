package cn.wfy.nikey;

import org.apache.coyote.OutputBuffer;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import sun.nio.ch.IOUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/***
 *
 * 把项目jar包复制到指定fffff路径
 *
 */
public class GetJar {

//    static ArrayList arrayList = new ArrayList(Arrays.asList("ems-business-exec.jar", "ems-data-delivery-exec.jar", "ems-dosage-statistics-exec.jar", "ems-eureka-server-exec.jar", "ems-file-exec.jar",
//            "ems-push2-exec.jar", "ems-rely-exec.jar", "ems-report-statistics-exec.jar", "ems-run-analysis-exec.jar", "ems-storage-exec.jar", "ems-system_v20-exec.jar", "ems-zuul-exec.jar"));

    static ArrayList arrayList = new ArrayList(Arrays.asList("ems-event-detect.jar","ems-event-notify.jar"));

//    static ArrayList arrayList = new ArrayList(Arrays.asList("ems-business-exec.jar", "ems-run-analysis-exec.jar", "ems-system_v20-exec.jar"));


    static String ffff = "E:\\project\\qzf\\20201224";

/*    public static void main(String[] args) {
        File file = new File("E:\\code\\main\\back-end\\ems-parent");
//        clearJar(file);
        getJar(file);

//        mvJar();
    }*/

    private static void clearJar(File file) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.getName().contains("jar")) {
                file1.delete();
            }
        }
    }

    private static void mvJar() {


        File file = new File(ffff);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                if (f.getName().contains(".jar")) {
                    int i = f.getName().lastIndexOf(".");
                    String suffixName = f.getName().substring(0, i);
                    String suffixName1 = suffixName.substring(0, suffixName.length() - 5);
                    String s = ffff + "/" + suffixName + "/" + f.getName();

                    File suffFileName = new File(ffff + "/" + suffixName);
                    File suffFileName1 = new File(ffff + "/" + suffixName1);
                    if (suffFileName.exists()) {
                        s = ffff + "/" + suffixName + "/" + f.getName();
                        System.out.println(s);
                        OutputStream writer = null;
                        InputStream reader = null;
                        try {

                            writer = new FileOutputStream(s);

                            reader = new FileInputStream(f);
                            IOUtils.copy(reader, writer);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else if (suffFileName1.exists()) {
                        s = ffff + "/" + suffixName1 + "/" + f.getName();
                        System.out.println(s);
                        OutputStream writer = null;
                        InputStream reader = null;
                        try {

                            writer = new FileOutputStream(s);

                            reader = new FileInputStream(f);
                            IOUtils.copy(reader, writer);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private static void getJar(File file) {
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                getJar(file1);
            } else {

                if (arrayList.contains(file1.getName())) {
                    System.out.println(file1.getName());
                    String realFile = file1.getName();
                    if (file1.getName().contains("ems-system_v20-exec.jar")) {
                        realFile = "ems-system-exec.jar";
                        System.out.println("修改成" + realFile);
                    }
                    if (file1.getName().contains("ems-push2-exec.jar")) {
                        realFile = "ems-push-exec.jar";
                        System.out.println("修改成" + realFile);

                    }

                    //
                    try {
                        File file2 = new File(ffff);
                        OutputStream writer = new FileOutputStream(file2 + "/" + realFile);
                        InputStream reader = new FileInputStream(file1);
                        IOUtils.copy(reader, writer);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
