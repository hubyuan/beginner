package cn.wfy.aop;

import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/2/16
 */
@Component
public class Boy implements IBuy {
    @Override
    public String buy() {
        System.out.println("boy1111111");
        return "hhhhh";
    }
}
