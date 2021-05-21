package cn.wfy.controller;

import cn.wfy.entity.ResponseApi;
import cn.wfy.entity.SellInVo;
import cn.wfy.service.SellInService;
import cn.wfy.service.SellOutService;
import cn.wfy.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/28
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private ShareService shareService;

    @Autowired
    private SellOutService sellOutService;
    @Autowired
    private SellInService sellInService;

    @RequestMapping("ioc")
    public ResponseApi iocTest() {
        int i = shareService.hashCode();
        ResponseApi responseApi = ResponseApi.ofSuccess(12123123);
        System.out.println(responseApi.toString());
        return responseApi;

    }

    @RequestMapping("initial")
    public void initial() {
        sellOutService.initial();
    }

    @RequestMapping("releaseShares")
    public void releaseShares() {
        SellInVo sellInVo = new SellInVo(null, 1L, 10001, 10, new Date(), "0", 10000);
        long start = System.currentTimeMillis();
        sellInService.releaseShares(sellInVo);
        long end = System.currentTimeMillis();
        System.out.println(end - start + "ms");

    }
}
