package cn.wfy.dao;

import cn.wfy.entity.Account;
import cn.wfy.utils.SnowFlakeGenerate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/4/11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void insert() {
        Account account = new Account(SnowFlakeGenerate.getId(), "hello", 10000000d);
        Account save = accountRepository.save(account);
        Account account1 = new Account(SnowFlakeGenerate.getId(), "sir", 10000000d);
        Account save1 = accountRepository.save(account1);
        Account account2 = new Account(SnowFlakeGenerate.getId(), "boy", 10000000d);
        Account save2 = accountRepository.save(account2);
    }

}