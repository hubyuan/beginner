package cn.wfy.dao;

import cn.wfy.entity.AccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/29
 */
public interface AccountInfoRepository extends JpaRepository<AccountInfo, Long>, JpaSpecificationExecutor<AccountInfo> {
}
