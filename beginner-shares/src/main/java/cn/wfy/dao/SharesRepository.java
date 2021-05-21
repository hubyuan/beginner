package cn.wfy.dao;

import cn.wfy.entity.Shares;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/27
 */
@Repository
public interface SharesRepository extends JpaRepository<Shares, Integer> {


}
