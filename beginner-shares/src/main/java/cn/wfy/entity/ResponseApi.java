package cn.wfy.entity;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/28
 */
public class ResponseApi {
    private int code;
    private String success;
    private Object data;

    public ResponseApi() {
    }

    public ResponseApi(int code, String success, Object data) {
        this.code = code;
        this.success = success;
        this.data = data;
    }

    public static ResponseApi ofSuccess(Object val) {
        return new ResponseApi(200, null, val);
    }

    public static ResponseApi ofFail(Object val) {
        return new ResponseApi(400, null, val);
    }

    @Override
    public String toString() {
        return "ResponseApi{" + "code=" + code + ", success='" + success + '\'' + ", data=" + data + '}';
    }
}
