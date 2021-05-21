package cn.wfy.其他.工作流.flow.newMethod;

import java.util.HashMap;
import java.util.Map;

public class Context {

    private Map<String, Object> resultMap = new HashMap();

    public Map getMap() {
        return resultMap;
    }

    public void setMap(Map<String, Object> map) {
        this.resultMap = map;
    }
}
