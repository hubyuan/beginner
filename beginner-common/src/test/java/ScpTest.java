import cn.wfy.util.Scpclient;

public class ScpTest {
    static String IP = "192.168.6.110";
    static int port = 40071;
    static String username = "abc";
    static String passward = "abc@123456";

    public static void main(String[] args) {

        Scpclient scpclient = Scpclient.getInstance(IP, port, username, passward);
// 拷贝
//        scpclient.getFile("/home/abc/program/update/test.txt", "E:\\project\\qzfdeploy\\scptest");
// 上传
        scpclient.putFile("E:\\project\\qzfdeploy\\scptest\\test1.txt", "/home/abc/program/update");
    }
}
