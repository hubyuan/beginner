package cn.wfy.service;

import cn.wfy.entity.SellOut;

import java.util.List;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/28
 */
public interface SellOutService {


    void initial();


    public void addBatch(List<SellOut> list);

    int testnum(int num);
}
