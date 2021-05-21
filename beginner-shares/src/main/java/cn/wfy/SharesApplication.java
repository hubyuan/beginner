package cn.wfy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/21
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"cn.wfy.service", "cn.wfy.dao"})
public class SharesApplication {
    public static void main(String[] args) {
        SpringApplication.run(SharesApplication.class, args);

    }

}
