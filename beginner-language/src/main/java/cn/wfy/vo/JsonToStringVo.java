package cn.wfy.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import java.io.Serializable;
import java.math.BigInteger;

public class JsonToStringVo implements Serializable {

    @JsonSerialize(using = ToStringSerializer.class)
    private BigInteger id;
    private String name;


    public JsonToStringVo() {
    }

    public JsonToStringVo(BigInteger id, String name) {
        this.id = id;
        this.name = name;
    }


    @JsonSerialize(using = ToStringSerializer.class)
    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
