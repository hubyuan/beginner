package cn.wfy.netty.vo;

public class ProtoVo {
    private int version;
    private int lenth;
    private Object data;

    public ProtoVo() {
    }

    public ProtoVo(int version, int lenth, Object data) {
        this.version = version;
        this.lenth = lenth;
        this.data = data;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getLenth() {
        return lenth;
    }

    public void setLenth(int lenth) {
        this.lenth = lenth;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
