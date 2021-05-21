package cn.wfy.util;

import java.io.*;
import java.util.ArrayList;

public class SearchKey {
    static ArrayList<String> listValues = new ArrayList<String>();


//    public static void main(String[] args) {
//
//        SearchKey searchKey = new SearchKey();
//        searchKey.search(new File("E:\\code\\main\\back-end\\ems-parent\\ems-app\\src\\main\\java\\com\\nikey\\ems"));
//
//        formatList(listValues);
//    }

    private static void formatList(ArrayList<String> listValues) {

        for (String listValue : listValues) {
            String head = "api-app-"+listValue+":\n";
            String foot = "  path: /api/app/"+listValue+"\n";
            String index = "  serviceId: app"+"\n";
            System.out.println(head+foot+index);

        }

    }

    final String key = "@RequestMapping";
    final String keyIgnore = "@RequestMapping(\"/api/app\")";
    final String keyIgnore1 = "@RequestMapping(\"api/app\")";
    final String keyIgnore2 = "@RequestMapping(\"api/puzzle\")";


    public void search(File file) {

        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                search(file1);
            } else if (file1.isFile()) {
                getFilesLine(file1);
            }
        }
    }

    private void getFilesLine(File file) {

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String content = null;
            while ((content = reader.readLine()) != null) {
                if (content.contains(key)) {
                    if (content.contains(keyIgnore) || content.contains(keyIgnore1) || content.contains(keyIgnore2)) {

                    } else {
                        String substring = content.substring(content.indexOf("\"") + 1, content.lastIndexOf("\""));
                        listValues.add(substring);

                        System.out.println(substring);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
