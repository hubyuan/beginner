package cn.wfy.nikey;

import java.util.Date;

public interface DateComponent1 {
    TimeMap getTimeMap(Date startTime,Date endTime);
    TimeMap getTimeMap(String startTime,String endTime);
    TimeMap getTimeMap(Date startTime,Integer timeType);
    TimeMap getTimeMap(String startTime,Integer timeType);
}
