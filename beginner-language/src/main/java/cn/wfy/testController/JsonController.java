package cn.wfy.testController;

import cn.wfy.vo.JsonToStringVo;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;

@RestController
@RequestMapping("api")
@EnableSwagger2
public class JsonController {

    //9 00719 92547 40991
    @RequestMapping("jsona")
    public JSONObject addCompanyPricingModeOfEnergyCost(HttpServletRequest request) {
        JsonToStringVo jsonToStringVo = new JsonToStringVo();
        Long dd = 1231231231223452323l;
        String kkk = "";
        jsonToStringVo.setId(BigInteger.valueOf(dd));
        jsonToStringVo.setName("333");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("eqw", jsonToStringVo.getId());
//        jsonObject.put("eqw2",jsonToStringVo.getName());
        jsonObject.put("eqw1", dd);
        jsonObject.put("eqw3", jsonToStringVo);
//        jsonObject.put("eqw1231","12312");
//        jsonObject.put("123123",kkk);
        return jsonObject;
    }

}
