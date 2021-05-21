package cn.wfy.controller;

import cn.wfy.service.IplogService;
import cn.wfy.service.JitangService;
import cn.wfy.vo.ApiReturn;
import cn.wfy.vo.Soul;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description TODO
 * @auther wfy
 * @since 2020/9/13
 */
@RestController
@RequestMapping("api")
public class JitangController {

    @Autowired
    private JitangService jitangService;


    @RequestMapping("getJitang")
    public ApiReturn getJitang(HttpServletRequest request){
        Soul jitang=jitangService.getJitang(request);


        return new ApiReturn("200",jitang);
    }


}
