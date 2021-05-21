package cn.wfy.service;

import cn.wfy.entity.SellIn;
import cn.wfy.entity.SellInVo;
import cn.wfy.entity.SellOut;

import java.util.List;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/28
 */
public interface SellInService {
    public void releaseShares(SellInVo sellInVo);

    public void addBatch(List<SellIn> list);
}
