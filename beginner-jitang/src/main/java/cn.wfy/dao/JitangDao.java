package cn.wfy.dao;

import cn.wfy.vo.Soul;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * @Description TODO
 * @auther wfy
 * @since 2020/9/13
 */
@Repository
public interface JitangDao extends JpaRepository<Soul, Integer> {

    @Query(value = "select * from soul s ORDER BY rand() limit 1",nativeQuery = true)
    Soul selectRand();
}
