package cn.wfy.assembly.asmTest;

/***
 *
 * @Description DaoFilter
 * @Author wfy
 * @Date 2021/5/24 14:26
 */

import org.springframework.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * 返回数值表示顺序
 */
public class DaoFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if("select".equalsIgnoreCase(method.getName())) {
            return 0;
        } else if ("delete".equalsIgnoreCase(method.getName())) {
            return 1;
        }
        return 2;
    }
}