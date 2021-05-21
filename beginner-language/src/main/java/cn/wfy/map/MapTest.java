package cn.wfy.map;

import java.util.Date;
import java.util.HashMap;

public class MapTest {
    public static void main(String[] args) {
        IkMap ikMap = new IkMap();
        ikMap.put("a", "bb");
        Object a = ikMap.get("a");
        System.out.println(a);
        HashMap hashMap = new HashMap();
        Object put = hashMap.put("hh", "mm");
        Object hh = hashMap.get("hh");
        System.out.println(hh);


    }
}
