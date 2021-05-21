package cn.wfy.dao;

import cn.wfy.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/4/11
 */
public interface AccountRepository  extends JpaRepository<Account, Long>, JpaSpecificationExecutor<Account> {
}
