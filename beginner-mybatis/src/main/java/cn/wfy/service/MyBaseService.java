package cn.wfy.service;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/21
 */
public interface MyBaseService {

    List<Map> selectAll();

    List<Map> selectTestDataById(String id);

    List<Map> selectTestDataByIdAndName(String id, String name);

}
