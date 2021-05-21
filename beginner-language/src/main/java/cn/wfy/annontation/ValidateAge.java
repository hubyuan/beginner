package cn.wfy.annontation;

import java.lang.annotation.*;

/**
 * @author Administrator
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD})
public @interface ValidateAge {
    /**
     * 最小值
     */
    int min() default 18;
    /**
     * 最大值
     */
    int max() default 99;
    /**
     * 默认值
     */
    int value() default 20;

}
