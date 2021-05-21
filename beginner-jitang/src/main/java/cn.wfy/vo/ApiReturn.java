package cn.wfy.vo;

import java.io.Serializable;

/**
 * @Description TODO
 * @auther wfy
 * @since 2020/9/13
 */
public class ApiReturn implements Serializable{
    private String code;
    private Object msg;

    public ApiReturn() {
    }

    public ApiReturn(String code, Object msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }
}
