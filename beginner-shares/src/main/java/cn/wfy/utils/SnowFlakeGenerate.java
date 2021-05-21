package cn.wfy.utils;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/27
 */
public class SnowFlakeGenerate {

    private final static SnowFlake snowFlake = new SnowFlake(1, 1);

    public static Long getId() {
        return snowFlake.nextId();
    }
}
