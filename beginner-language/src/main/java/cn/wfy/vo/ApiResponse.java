package cn.wfy.vo;

public class ApiResponse {
    private Integer code;
    private boolean success;
    private String msg;
    private Object data;

    public ApiResponse() {
    }

    public ApiResponse(Integer code, boolean success, String msg, Object data) {
        this.code = code;
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ApiResponse ofSuccess() {
        return new ApiResponse(null, true, null, null);
    }

    public static ApiResponse ofSuccess(String msg) {
        return new ApiResponse(null, true, msg, null);
    }
}