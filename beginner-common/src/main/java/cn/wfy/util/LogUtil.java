package cn.wfy.util;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.io.*;
import java.util.Date;
import java.util.logging.Level;

public class LogUtil {
    public void info(String mes) {
        info(mes, null);
    }

    public void info(String mes, String fileName) {
        if (fileName == null) {
            fileName = "./test.log";
        }
        bug(mes, fileName, "INFO");

    }

    public void log(int level, String mes) {
        info(mes);
    }

    private void bug(String mes, String fileName, String level) {
        try {
            StringBuffer stringBuffer = new StringBuffer();

            String dateFormat = DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss.SSS");
            stringBuffer.append(dateFormat);
            stringBuffer.append("   " + level + "   ");
            stringBuffer.append(mes + "\r");
            OutputStream outputStream = new FileOutputStream(fileName, true);
            outputStream.write(stringBuffer.toString().getBytes("utf8"));
            outputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
