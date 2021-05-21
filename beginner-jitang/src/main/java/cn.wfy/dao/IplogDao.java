package cn.wfy.dao;

import cn.wfy.vo.Iplog;
import cn.wfy.vo.Soul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * @Description TODO
 * @auther wfy
 * @since 2020/9/13
 */
@Repository
public interface IplogDao extends JpaRepository<Iplog, Long> {

    @Query(value = "SELECT * FROM iplog WHERE ip = :ip ORDER BY date desc LIMIT 1",nativeQuery = true)
    Iplog findLastOne(@Param("ip") String ip);
}
