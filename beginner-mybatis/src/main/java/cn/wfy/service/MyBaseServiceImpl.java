package cn.wfy.service;

import cn.wfy.dao.MyBaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/21
 */
@Service
public class MyBaseServiceImpl implements MyBaseService {

    @Autowired
    private MyBaseMapper myBaseMapper;
    @Override
    public List<Map> selectAll() {
        List<Map> maps = myBaseMapper.selectTestData();
        return maps;
    }

    @Override
    public List<Map> selectTestDataById(String id) {
        List<Map> maps = myBaseMapper.selectTestDataById(id);
        return maps;
    }

    @Override
    public List<Map> selectTestDataByIdAndName(String id, String name) {
        List<Map> maps = myBaseMapper.selectTestDataByIdAndName(id,name);
        return maps;
    }
}
