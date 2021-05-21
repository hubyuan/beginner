package cn.wfy.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description TODO
 * @auther wfy
 * @since 2020/9/22
 */
@RestController
@RequestMapping("attack")
public class Attack {

    @RequestMapping("one")
    public void attackOne(HttpServletRequest request){

    }


}
