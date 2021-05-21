package cn.wfy.service.impl;

import cn.wfy.service.MyBatisService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyBatisServiceImpl implements MyBatisService {

//    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteAllById(String id) {

        int a = 0;
        int b = 0;
        int c = a / b;

    }


}
