package cn.wfy.assembly;

import java.lang.reflect.*;

/***
 *
 * @Description JdkProxyTest
 * @Author wfy
 * @Date 2021/5/24 15:22
 */
public class JdkProxyTest {
    public static void main(String[] args) {
        //1.获取并输出类的名称
        Class mClass = JdkProxyTest.class;
        System.out.println("类的名称：" + mClass.getName());

        //2.1 获取所有 public 访问权限的变量
        // 包括本类声明的和从父类继承的
        Field[] fields = mClass.getFields();
        Method[] methods = mClass.getMethods();
        for (Method method : methods) {
            try {
                method.invoke("","");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        //2.2 获取所有本类声明的变量（不问访问权限）
        //Field[] fields = mClass.getDeclaredFields();


    }

    private void save() {

    }
}
