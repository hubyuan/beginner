package cn.wfy.annontation;

import cn.wfy.netty.test.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 注解测试类
 * 使用技术： 反射
 * @author Administrator
 */
public class AnnontationTest {
    public static void main(String[] args) {
        User user = new User();
        user.setAge(33);
        initUser(user);
    }

    private static boolean initUser(User user) {
        boolean result = true;
        Field[] fields = User.class.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            boolean present = field.isAnnotationPresent(ValidateAge.class);
            if (!present) {
                continue;
            }
            ValidateAge validateAge = field.getAnnotation(ValidateAge.class);
            field.setAccessible(true);
            int age = 0;
            try {
                age = (int) field.get(user);

                if (age < validateAge.min() || age > validateAge.max()) {
                    result = false;
                    System.out.println("年龄值不符合条件");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
