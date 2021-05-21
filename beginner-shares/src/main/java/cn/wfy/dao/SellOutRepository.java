package cn.wfy.dao;

import cn.wfy.entity.SellOut;
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
public interface SellOutRepository extends JpaRepository<SellOut, Long>, JpaSpecificationExecutor<SellOut> {

    @Query(nativeQuery = true, value = "select * from sell_out WHERE  is_delete ='0' ORDER BY price ASC ,update_time limit 10000")
    List<SellOut> findOutAll();

    @Query(nativeQuery = true, value = "select * from sell_out WHERE  is_delete ='0' ORDER BY price ASC ,update_time limit :number")
    List<SellOut> findOutAll1(@Param("number") Integer number);

    @Query(nativeQuery = true, value = "select * from sell_out where code = :code and price <= :price and is_delete = '0' ORDER BY price asc, update_time limit :number")
    List<SellOut> isMatch(@Param("code") Integer code,@Param("price")  Double price, @Param("number") Integer number);


    @Query(nativeQuery = true, value = "select * from 'sell_out' where 'code' = :code and 'price' > :price and 'is_delete' = '0' ORDER BY 'price' asc, 'update_time' limit :number")
    List<SellOut> isMatch1(@Param("code") Integer code,@Param("price")  Double price, @Param("number") Integer number);
}
