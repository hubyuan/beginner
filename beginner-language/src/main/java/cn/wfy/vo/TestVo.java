package cn.wfy.vo;



public class TestVo {

    private String hello;
    private String world;

    public TestVo(String hello, String world) {
        this.hello = hello;
        this.world = world;
    }

    public TestVo() {
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public String getWorld() {
        return world;
    }

    public void setWorld(String world) {
        this.world = world;
    }

    @Override
    public String toString() {
        return "TestVo{" +
                "hello='" + hello + '\'' +
                ", world='" + world + '\'' +
                '}';
    }
}
