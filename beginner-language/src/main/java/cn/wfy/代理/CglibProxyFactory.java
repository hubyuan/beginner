package cn.wfy.代理;

import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
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

    public static void main(String[] args)throws Exception {
//        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);


        AliSmsService u = new AliSmsService();
            Class clazz = u.getClass();
            Method m = clazz.getMethod("send", String.class);
            m.setAccessible(true);
            m.invoke(u, "bbb");


        for (Parameter parameter : m.getParameters()) {
            System.out.println(parameter.getName());
        }

        for (Field declaredField : clazz.getFields()) {
            System.out.println(declaredField.getName());
        }

//        try {
//            Class<? extends AliSmsService> aClass = AliSmsService.class.newInstance().getClass();
//            Method send = aClass.getMethod("send",String.class);
//            Object hello = send.invoke(aClass, "hello");
//            for (Field declaredField : aClass.getDeclaredFields()) {
//                System.out.println(declaredField.getName());
//            }
//
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }

//
//        aliSmsService.send("java");
//
//        Class<?>[] interfaces = aliSmsService.getClass().getInterfaces();
//        Arrays.stream(interfaces).forEach(vo -> System.out.println(vo.getSimpleName()));
    }
}
