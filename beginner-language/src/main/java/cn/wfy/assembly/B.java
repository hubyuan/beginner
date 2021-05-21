package cn.wfy.assembly;

import java.util.HashMap;
import java.util.Map;

/***
 *
 * @Description B
 * @Author wfy
 * @Date 2021/5/8 10:56
 */
public class B extends A{
    private String name;
    private String name1;


    public void fucking(String str){
        int count =0;
        Map<String,Object> hashMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            hashMap.put(String.valueOf(i),i);
            count++;
        }
    }
}
