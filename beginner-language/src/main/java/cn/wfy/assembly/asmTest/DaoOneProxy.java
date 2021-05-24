package cn.wfy.assembly.asmTest;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/***
 *
 * @Description DaoOneProxy
 * @Author wfy
 * @Date 2021/5/24 14:25
 */
public class DaoOneProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("begin intercept");
        //invokeSuper方法调用目标类的方法
        methodProxy.invokeSuper(o, objects);
        System.out.println("end intercept");
        return o;
    }
}
