package cn.wfy.review;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class Tests {
    public static void main(String[] args) {

        String bb =
                "ems-eureka-server-exec\n" +
                        "ems-data-delivery-exec\n" +
                        "ems-business-exec\n" +
                        "ems-dosage-statistics-exec\n" +
                        "ems-file-exec\n" +
                        "ems-push-exec\n" +
                        "ems-rely-exec\n" +
                        "ems-report-statistics-exec\n" +
                        "ems-storage-exec\n" +
                        "ems-run-analysis-exec\n" +
                        "ems-system-exec\n" +
                        "ems-zuul-exec\n" +
                        "ems-alarm-exec";
        String[] split = bb.split("\n");
        ArrayList<String> objects = new ArrayList<>();
//        for (String s : split) {
//            objects.add(s);
//
////            String ppp = "nohup java -jar "+s+"/"+s+".jar"+"  --spring.config.location=./database.yml,"+s+"/application.yml > "+s+"/logs/nohup.out &";
//            String ppp = "nohup java -jar "+s+"/"+s+".jar"+"  --spring.config.location=./database.yml,"+s+"/application.yml &";
//            System.out.println(ppp);
//            System.out.println("echo "+s+" finish!");
//            System.out.println("sleep 1");
//
//
//        }

//        for (String s : split) {
//            String ee = "ps -fe|grep "+s+" |grep -v grep";
//            System.out.println(ee);
//        }

//        for (int i = 0; i < split.length; i++) {
//            System.out.println("APP_NAME["+i+"]="+split[i]);
//
//        }

        String idd = "[1313123]";
        List<Long> list = JSON.parseArray(idd, Long.class);
        for (Long aLong : list) {
            System.out.println(aLong);
        }


    }
    //103183
}
