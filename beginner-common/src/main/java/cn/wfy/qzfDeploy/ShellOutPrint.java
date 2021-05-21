package cn.wfy.qzfDeploy;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Component
@Aspect
@Slf4j
public class ShellOutPrint {


    /**
     * 档案操作切入点
     */
    @Pointcut("@annotation( cn.wfy.qzfDeploy.returnNum )")
    public void operateCut() {
    }


    @AfterReturning(value = "operateCut()", returning = "keys")
    public void pushCompanyInfoOperationInfoIntoQueue(JoinPoint jp, Object keys) {
        try {
            Integer[] integers = (Integer[]) keys;
            for (int i = 0; i < integers.length; i++) {
                if (i == 0) {
                    if (integers[i] == 0) {
                        System.out.println("凯达成功");

                    } else {
                        System.out.println("凯达失败");

                    }
                }
                if (i == 1) {
                    if (integers[i] == 0) {
                        System.out.println("凯通成功");

                    } else {
                        System.out.println("凯通失败");

                    }
                }
                if (i == 2) {
                    if (integers[i] == 0) {
                        System.out.println("人武成功");

                    } else {
                        System.out.println("人武失败");

                    }
                }
                if (i == 3) {
                    if (integers[i] == 0) {
                        System.out.println("加压站成功");

                    } else {
                        System.out.println("加压站失败");

                    }
                }
                if (i == 4) {
                    if (integers[i] == 0) {
                        System.out.println("中心系统成功");

                    } else {
                        System.out.println("中心系统失败");

                    }
                }
                if (i == 5) {
                    if (integers[i] == 0) {
                        System.out.println("行政中心成功");

                    } else {
                        System.out.println("行政中心失败");

                    }
                }

            }

        } catch (Exception e) {
        }
    }


}
