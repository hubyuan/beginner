package cn.wfy.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/21
 */
@Mapper
public interface MyBaseMapper{

    @Select("SELECT * FROM `user`")
    List<Map> selectTestData();


    @Select("SELECT * FROM `user` where  id = #{id}")
    List<Map> selectTestDataById(String id);

    @Select("SELECT * FROM `user` where  id = #{id} and username = #{name}")
    List<Map> selectTestDataByIdAndName(@Param(value = "id") String id, @Param(value = "name") String name);
}
