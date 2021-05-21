package cn.wfy.testController;

import cn.wfy.Test;
import cn.wfy.map.CurrentMap;
import cn.wfy.map.MapTest;
import cn.wfy.speed.Alllock;
import cn.wfy.util.SpringContextUtils;
import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.tools.Shell;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.stream.IntStream;

@RestController
@RequestMapping("api")
public class SpringController {

    static JSONObject jsonObject =new JSONObject();
    @RequestMapping("eee")
    public void aaa(){

        ArrayList<Thread> arrayList = new ArrayList<>(1000);
        IntStream.range(0, 10).forEach(u -> arrayList.add(new Thread(() -> {
            IntStream.range(0, 10).forEach(v -> {
                eee();
            });
        })));
        arrayList.forEach(Thread::start);


    }

    private void eee(){
        jsonObject.put(Thread.currentThread().getName(),123);

    }
}
