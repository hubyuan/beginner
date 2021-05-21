package cn.wfy.controller;

import cn.wfy.service.IocTestService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/27
 */
public class IocTestController {
    @Autowired
    private IocTestService iocTestService;
}
