package cn.wfy.dao;

import cn.wfy.entity.SellIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/27
 */
@Repository
public interface SellInRepository extends JpaRepository<SellIn, Long>, JpaSpecificationExecutor<SellIn> {

    @Query(nativeQuery = true, value = "select * from sell_in WHERE  is_delete ='0' ORDER BY price ,update_time limit 10000")
    List<SellIn> findInAll();

    @Query(nativeQuery = true, value = "select * from sell_in where code = #{code} and price >= #{price} and is_delete = '0' ORDER BY price , update_time limit #{number}}")
    List<SellIn> isMatch(@Param("code") Integer code, @Param("price")  Double price, @Param("number") Integer number);
}
