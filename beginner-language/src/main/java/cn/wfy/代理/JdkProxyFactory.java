package cn.wfy.代理;

import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/2/16
 */
public class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                new JdkHandle(target)   // 代理对象对应的自定义 InvocationHandler
        );
    }

    public static void main(String[] args) {
        InvocationService proxy =(InvocationService) JdkProxyFactory.getProxy(new InvocationServiceImp());
        proxy.fo();
        Class<?>[] interfaces = proxy.getClass().getInterfaces();
        Arrays.stream(interfaces).forEach(vo -> System.out.println(vo.getSimpleName()));
    }
}
