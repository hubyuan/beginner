package cn.wfy.nikey;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class DataLoadingComponent {
    private DataLoadingComponent node;

    private JSONObject dataObject;
    private JSONArray dataArray;

    private String key;

    public JSONObject getDataObject() {
        return dataObject;
    }

    public void setDataObject(String key) {
        if (dataArray == null) {
            if (dataObject==null) {
                dataObject = new JSONObject();
            }
            dataObject.put(key,null);
            this.key=key;
        }
    }

    public JSONArray getDataArray() {
        return dataArray;
    }

    public void setDataArray(Object value) {
        if (dataObject == null) {
            if (dataObject==null) {
                dataArray = new JSONArray();
            }
            dataArray.add(value);
        }
    }
    public void setValue(Object value){

        if (key != null) {
            dataObject.put(key,value);
        }

        if (dataObject == null) {
            if (dataObject==null) {
                dataArray = new JSONArray();
            }
            dataArray.add(value);
        }
    }

    public void setNode(DataLoadingComponent child) {
        this.node = child;

    }

    public DataLoadingComponent getNode() {
        return node;

    }


}
