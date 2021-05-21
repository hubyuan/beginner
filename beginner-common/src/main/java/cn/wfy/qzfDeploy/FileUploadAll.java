package cn.wfy.qzfDeploy;

import cn.wfy.util.Scpclient;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/***
 * 须知:
 * sql需要删除表:company_repository , statistics_record
 * 前端包需要删除:6个config.js文件
 *
 */
public class FileUploadAll {

    static String IP = "192.168.6.110";
    static int port = 40071;
    static String username = "abc";
    static String passward = "abc@123456";

    /***
     *
     * 1.测试jar包自动更新
     * 2.sql自动更新： 测试1：加压站- 测试2：
     * 3.测试shell脚本上传， 测试1：全部失败 （中心系统成功） 测试2：全部成功
     * 4.
     * @param args
     */
/*    public static void main(String[] args) {
        start();
//        clean();
//        command();
    }*/

    private static void clean() {
        ShellQzfNew shellQzf = new ShellQzfNew();
        shellQzf.cleanAll();
    }



    private static void command() {
        ShellQzfNew shellQzf = new ShellQzfNew();
        shellQzf.command("all");
    }


    private static void start() {

        //windows到linux
        String srcFile = "E:\\project\\qzf\\20210126\\update\\";//最后面需要加\\
//        String srcFile = "E:\\project\\qzf\\";//最后面需要加\\
        //jar包更新

        List<String> srcNameList =  getJar(srcFile);
        //前端包更新
//        List<String> srcNameList = Arrays.asList("1228.zip");
        //文件更新
//        List<String> srcNameList = Arrays.asList("application-routes-file.yml");
        //sql文件更新
//        List<String> srcNameList = Arrays.asList("fastenergy_info_qzf_center.zip");
//        List<String> srcNameList = Arrays.asList("qzfLogo.png");

        String destName = "/home/abc/program/qzf";
//        String destName = "/home/abc/桌面";

        for (int i = 0; i < srcNameList.size(); i++) {
            Scpclient scpclient = Scpclient.getInstance(IP, port, username, passward);
            // 上传
            scpclient.putFile(srcFile + srcNameList.get(i), destName);
            System.out.println("行政中心上传成功");

            //linux 到linux
            ShellQzfNew shellQzf = new ShellQzfNew();
            //shell
            if (srcNameList.get(i).contains(".properties")) {
                shellQzf.replaceFile(destName, srcNameList.get(i),"/ems-event-detect",srcNameList.get(i));

            }
            //sql/vue
            if (srcNameList.get(i).contains(".zip")) {
                if (srcNameList.get(i).contains("qzf")) {
                    shellQzf.sqlUpdateAll(destName, srcNameList.get(i), true);
                } else {
                    shellQzf.vueUpdateAll(destName, srcNameList.get(i), true);
                }
            }
            //jar
            if (srcNameList.get(i).contains(".jar")||srcNameList.get(i).contains(".png")) {
                shellQzf.springUpdateAll(destName, srcNameList.get(i), true);
            }

        }

    }

    private static List<String> getJar(String srcFile) {
        List<String> srcNameList = new ArrayList<>();
        File file = new File(srcFile);
        File[] files = file.listFiles();
        for (File file1 : files) {
            srcNameList.add(file1.getName());
        }
        return srcNameList;
    }
}
