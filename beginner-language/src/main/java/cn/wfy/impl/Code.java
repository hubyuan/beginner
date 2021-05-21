package cn.wfy.impl;

public enum Code {
    ONE(1,"one"),TWO(2,"two");

    private final int code;
    private final String test;



    Code(int code, String test) {
        this.code = code;
        this.test = test;
    }

    public int getCode() {
        return code;
    }

    public String getTest() {
        return test;
    }
}
