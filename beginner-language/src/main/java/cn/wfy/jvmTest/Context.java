package cn.wfy.jvmTest;

import java.util.HashMap;

/***
 *
 * @Description Context
 * @Author wfy
 * @Date 2021/5/29 17:17
 */
public class Context {
    private static HashMap<String,String> hashMap =new HashMap();
    private static   Aaa aaa=new Aaa();

    public void setaaa(String a,String b){
        hashMap.put(a,b);
        aaa.setName(a);
        aaa.setAge(b);
    }

    public void clear(){
        aaa=null;
        hashMap=null;
    }
}
