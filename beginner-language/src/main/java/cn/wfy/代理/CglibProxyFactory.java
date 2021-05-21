package cn.wfy.代理;

import org.springframework.cglib.proxy.Enhancer;

import java.util.Arrays;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/2/16
 */
public class CglibProxyFactory {
    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor());
        // 创建代理类
        return enhancer.create();
    }

    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("java");
        Class<?>[] interfaces = aliSmsService.getClass().getInterfaces();
        Arrays.stream(interfaces).forEach(vo -> System.out.println(vo.getSimpleName()));
    }
}
