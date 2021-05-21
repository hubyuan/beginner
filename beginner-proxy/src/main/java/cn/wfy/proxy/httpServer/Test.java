package cn.wfy.proxy.httpServer;

public class Test {
    public static void main(String[] args) {


        String aa = "GET http://10.0.0.2:7042/js/chunk-vendors.f2feb123.js.map HTTP/1.1\n";
        int i = aa.indexOf("7042");
        System.out.println(i);
    }
}
