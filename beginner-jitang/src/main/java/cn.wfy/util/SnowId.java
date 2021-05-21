package cn.wfy.util;

/**
 * @Description TODO
 * @auther wfy
 * @since 2020/9/13
 */
public class SnowId {
    private static SnowflakeIdWorker snowflakeIdWorker;


    public static Long getId(){
        if (snowflakeIdWorker==null){
            snowflakeIdWorker=new SnowflakeIdWorker(1,2);
        }
       return snowflakeIdWorker.nextId();
    }
}
