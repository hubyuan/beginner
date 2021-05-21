package cn.wfy;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class HelloRunner implements CommandLineRunner {


    @Autowired
    private HelloSender helloSender;

    @Override
    public void run(String... args) throws Exception {
        old();
//        newInvole();
    }

    private void newInvole() throws Exception {

        while (true) {
            Thread.sleep(1);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[{\"data\":[{\"pointCode\":\"101\",\"pointNumber\":\"0\",\"value\":\"409.353299\"},{\"pointCode\":\"102\",\"pointNumber\":\"0\",\"value\":\"323.451340\"},{\"pointCode\":\"103\",\"pointNumber\":\"0\",\"value\":\"238.736935\"},{\"pointCode\":\"201\",\"pointNumber\":\"0\",\"value\":\"419.155562\"},{\"pointCode\":\"202\",\"pointNumber\":\"0\",\"value\":\"166.192388\"},{\"pointCode\":\"203\",\"pointNumber\":\"0\",\"value\":\"478.831822\"},{\"pointCode\":\"204\",\"pointNumber\":\"0\",\"value\":\"108.031780\"},{\"pointCode\":\"205\",\"pointNumber\":\"0\",\"value\":\"486.122102\"},{\"pointCode\":\"206\",\"pointNumber\":\"0\",\"value\":\"129.211115\"},{\"pointCode\":\"207\",\"pointNumber\":\"0\",\"value\":\"207.803540\"},{\"pointCode\":\"208\",\"pointNumber\":\"0\",\"value\":\"299.489582\"},{\"pointCode\":\"209\",\"pointNumber\":\"0\",\"value\":\"315.194799\"},{\"pointCode\":\"210\",\"pointNumber\":\"0\",\"value\":\"161.026887\"},{\"pointCode\":\"211\",\"pointNumber\":\"0\",\"value\":\"314.229009\"},{\"pointCode\":\"212\",\"pointNumber\":\"0\",\"value\":\"315.507543\"},{\"pointCode\":\"213\",\"pointNumber\":\"0\",\"value\":\"117.997295\"},{\"pointCode\":\"214\",\"pointNumber\":\"0\",\"value\":\"446.630380\"},{\"pointCode\":\"215\",\"pointNumber\":\"0\",\"value\":\"332.555724\"},{\"pointCode\":\"216\",\"pointNumber\":\"0\",\"value\":\"208.222660\"},{\"pointCode\":\"217\",\"pointNumber\":\"0\",\"value\":\"211.858991\"},{\"pointCode\":\"218\",\"pointNumber\":\"0\",\"value\":\"201.033027\"},{\"pointCode\":\"219\",\"pointNumber\":\"0\",\"value\":\"452.518230\"},{\"pointCode\":\"220\",\"pointNumber\":\"0\",\"value\":\"418.105207\"},{\"pointCode\":\"221\",\"pointNumber\":\"0\",\"value\":\"395.270669\"},{\"pointCode\":\"222\",\"pointNumber\":\"0\",\"value\":\"101.342546\"},{\"pointCode\":\"223\",\"pointNumber\":\"0\",\"value\":\"412.999064\"},{\"pointCode\":\"224\",\"pointNumber\":\"0\",\"value\":\"310.367811\"},{\"pointCode\":\"225\",\"pointNumber\":\"0\",\"value\":\"191.514748\"},{\"pointCode\":\"226\",\"pointNumber\":\"0\",\"value\":\"235.106523\"},{\"pointCode\":\"227\",\"pointNumber\":\"0\",\"value\":\"327.883941\"},{\"pointCode\":\"228\",\"pointNumber\":\"0\",\"value\":\"341.343985\"},{\"pointCode\":\"403\",\"pointNumber\":\"0\",\"value\":\"372.086749\"},{\"pointCode\":\"404\",\"pointNumber\":\"0\",\"value\":\"372.963602\"},{\"pointCode\":\"405\",\"pointNumber\":\"0\",\"value\":\"300.634791\"},{\"pointCode\":\"406\",\"pointNumber\":\"0\",\"value\":\"207.410129\"},{\"pointCode\":\"407\",\"pointNumber\":\"0\",\"value\":\"135.788442\"},{\"pointCode\":\"408\",\"pointNumber\":\"0\",\"value\":\"319.680012\"},{\"pointCode\":\"409\",\"pointNumber\":\"0\",\"value\":\"118.629043\"},{\"pointCode\":\"501\",\"pointNumber\":\"0\",\"value\":\"459.825224\"},{\"pointCode\":\"502\",\"pointNumber\":\"0\",\"value\":\"256.652152\"},{\"pointCode\":\"234\",\"pointNumber\":\"0\",\"value\":\"104.787367\"},{\"pointCode\":\"235\",\"pointNumber\":\"0\",\"value\":\"392.655074\"},{\"pointCode\":\"242\",\"pointNumber\":\"0\",\"value\":\"490.537595\"}],\"measureId\":\"5755385524366233134\",");
            String formatTime = DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
            stringBuilder.append("\"time\":\"" + formatTime + ".000" + "\"}]");

            helloSender.sendMessage(stringBuilder.toString());
        }
    }

    private void old() throws Exception {
        Date date = DateUtils.parseDate("2020-12-04 00:00:00", "yyyy-MM-dd HH:mm:ss");

        while (true) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[{\"data\":[{\"pointCode\":\"101\",\"pointNumber\":\"0\",\"value\":\"409.353299\"},{\"pointCode\":\"102\",\"pointNumber\":\"0\",\"value\":\"323.451340\"},{\"pointCode\":\"103\",\"pointNumber\":\"0\",\"value\":\"238.736935\"},{\"pointCode\":\"201\",\"pointNumber\":\"0\",\"value\":\"419.155562\"},{\"pointCode\":\"202\",\"pointNumber\":\"0\",\"value\":\"166.192388\"},{\"pointCode\":\"203\",\"pointNumber\":\"0\",\"value\":\"478.831822\"},{\"pointCode\":\"204\",\"pointNumber\":\"0\",\"value\":\"108.031780\"},{\"pointCode\":\"205\",\"pointNumber\":\"0\",\"value\":\"486.122102\"},{\"pointCode\":\"206\",\"pointNumber\":\"0\",\"value\":\"129.211115\"},{\"pointCode\":\"207\",\"pointNumber\":\"0\",\"value\":\"207.803540\"},{\"pointCode\":\"208\",\"pointNumber\":\"0\",\"value\":\"299.489582\"},{\"pointCode\":\"209\",\"pointNumber\":\"0\",\"value\":\"315.194799\"},{\"pointCode\":\"210\",\"pointNumber\":\"0\",\"value\":\"161.026887\"},{\"pointCode\":\"211\",\"pointNumber\":\"0\",\"value\":\"314.229009\"},{\"pointCode\":\"212\",\"pointNumber\":\"0\",\"value\":\"315.507543\"},{\"pointCode\":\"213\",\"pointNumber\":\"0\",\"value\":\"117.997295\"},{\"pointCode\":\"214\",\"pointNumber\":\"0\",\"value\":\"446.630380\"},{\"pointCode\":\"215\",\"pointNumber\":\"0\",\"value\":\"332.555724\"},{\"pointCode\":\"216\",\"pointNumber\":\"0\",\"value\":\"208.222660\"},{\"pointCode\":\"217\",\"pointNumber\":\"0\",\"value\":\"211.858991\"},{\"pointCode\":\"218\",\"pointNumber\":\"0\",\"value\":\"201.033027\"},{\"pointCode\":\"219\",\"pointNumber\":\"0\",\"value\":\"452.518230\"},{\"pointCode\":\"220\",\"pointNumber\":\"0\",\"value\":\"418.105207\"},{\"pointCode\":\"221\",\"pointNumber\":\"0\",\"value\":\"395.270669\"},{\"pointCode\":\"222\",\"pointNumber\":\"0\",\"value\":\"101.342546\"},{\"pointCode\":\"223\",\"pointNumber\":\"0\",\"value\":\"412.999064\"},{\"pointCode\":\"224\",\"pointNumber\":\"0\",\"value\":\"310.367811\"},{\"pointCode\":\"225\",\"pointNumber\":\"0\",\"value\":\"191.514748\"},{\"pointCode\":\"226\",\"pointNumber\":\"0\",\"value\":\"235.106523\"},{\"pointCode\":\"227\",\"pointNumber\":\"0\",\"value\":\"327.883941\"},{\"pointCode\":\"228\",\"pointNumber\":\"0\",\"value\":\"341.343985\"},{\"pointCode\":\"403\",\"pointNumber\":\"0\",\"value\":\"372.086749\"},{\"pointCode\":\"404\",\"pointNumber\":\"0\",\"value\":\"372.963602\"},{\"pointCode\":\"405\",\"pointNumber\":\"0\",\"value\":\"300.634791\"},{\"pointCode\":\"406\",\"pointNumber\":\"0\",\"value\":\"207.410129\"},{\"pointCode\":\"407\",\"pointNumber\":\"0\",\"value\":\"135.788442\"},{\"pointCode\":\"408\",\"pointNumber\":\"0\",\"value\":\"319.680012\"},{\"pointCode\":\"409\",\"pointNumber\":\"0\",\"value\":\"118.629043\"},{\"pointCode\":\"501\",\"pointNumber\":\"0\",\"value\":\"459.825224\"},{\"pointCode\":\"502\",\"pointNumber\":\"0\",\"value\":\"256.652152\"},{\"pointCode\":\"234\",\"pointNumber\":\"0\",\"value\":\"104.787367\"},{\"pointCode\":\"235\",\"pointNumber\":\"0\",\"value\":\"392.655074\"},{\"pointCode\":\"242\",\"pointNumber\":\"0\",\"value\":\"490.537595\"}],\"measureId\":\"5755385524366233134\",");
            date = DateUtils.addSeconds(date, 1);
            String formatTime = DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
            stringBuilder.append("\"time\":\"" + formatTime + ".000" + "\"}]");

            helloSender.sendMessage(stringBuilder.toString());
        }
    }

}
