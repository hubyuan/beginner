package cn.wfy.assembly.asmTest;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/***
 *
 * @Description DaoAnotherProxy
 * @Author wfy
 * @Date 2021/5/24 14:28
 */
public class DaoAnotherProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("开始intercept");
        proxy.invokeSuper(obj, args);
        System.out.println("结束intercept");
        return obj;
    }
}