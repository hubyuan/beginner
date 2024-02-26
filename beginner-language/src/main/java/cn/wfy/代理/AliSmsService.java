package cn.wfy.代理;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/2/16
 */
public class AliSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        String pppp = message+"aaa";
        return message;
    }
}
