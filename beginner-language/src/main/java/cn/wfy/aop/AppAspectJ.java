package cn.wfy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/2/16
 */
@Aspect
@Component
public class AppAspectJ {
//    @Before("execution(* IBuy.buy(  ..))")
//    public void haha() {
//        System.out.println("男孩女孩都买自己喜欢的东西");
//    }

    @After("execution(* IBuy.buy(  ..))")
    public void haha1(JoinPoint joinPoint) {
        try {

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("男孩女孩都买自己喜欢的东西");
    }
}
