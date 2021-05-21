package cn.wfy.lock.atomic;

public class AtomicVo {
    private String dataTime;
    private String datavalue;

    public AtomicVo() {
    }

    public AtomicVo(String dataTime, String datavalue) {
        this.dataTime = dataTime;
        this.datavalue = datavalue;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String getDatavalue() {
        return datavalue;
    }

    public void setDatavalue(String datavalue) {
        this.datavalue = datavalue;
    }

}
