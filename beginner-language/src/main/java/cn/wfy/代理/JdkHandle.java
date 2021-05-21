package cn.wfy.代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/2/16
 */
public class JdkHandle implements InvocationHandler {
    private final Object target;

    public JdkHandle(Object target) {
        this.target = target;
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("bbbbbbb");
        Object invoke = method.invoke(target, args);
        return invoke;
    }

}
