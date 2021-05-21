package cn.wfy.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/2/16
 */
@Configuration
@ComponentScan(basePackageClasses = {IBuy.class})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
}
