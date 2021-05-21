package cn.wfy.nikey;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static cn.wfy.nikey.Consts.*;

/***
 * 时间转换类
 */
@Slf4j
public class DateComponent implements DateComponent1 {

    /**
     * The minimum supported epoch second.
     */
    private static final long MIN_SECOND = -31557014167219200L;
    /**
     * The maximum supported epoch second.
     */
    private static final long MAX_SECOND = 31556889864403199L;

    @Override
    public TimeMap getTimeMap(Date startTime, Date endTime) {
        Long instant = getInstant(startTime, endTime);
        Integer type = instantType(instant);
        return new TimeMap(type, startTime, endTime);
    }

    @Override
    public TimeMap getTimeMap(String startTime, String endTime) {
        Long instant = getInstant(startTime, endTime);
        Integer type = instantType(instant);
        return new TimeMap(type, startTime, endTime);
    }

    @Override
    public TimeMap getTimeMap(Date startTime, Integer type) {
        Date endTime = getEndTime(startTime, type);
        return new TimeMap(type, startTime, endTime);
    }

    @Override
    public TimeMap getTimeMap(String startTime, Integer type) {

        Date endTime = getEndTime(startTime, type);

        return new TimeMap(type, startTime, endTime);
    }

    private Date getEndTime(String startTime, Integer type) {
        try {
            return getEndTime(DateUtils.parseDate(startTime, "yyyy-MM-dd HH:mm:ss"), type);
        } catch (ParseException e) {
            e.printStackTrace();
            log.error("时间类型转换异常");
        }
        return null;
    }

    private Date getEndTime(Date startTime, Integer type) {
        Date endTime = null;
        if (type == YEAR) {
            endTime = DateUtils.addYears(startTime, -1);
        }
        if (type == MONTH) {
            endTime = DateUtils.addMonths(startTime, -1);
        }
        if (type == DAY) {
            endTime = DateUtils.addDays(startTime, -1);
        }


        return endTime;
    }


    public Long getInstant(Date startTime, Date endTime) {
        Instant startTimeIn = Instant.ofEpochMilli(startTime.getTime());
        Instant endTimeIn = Instant.ofEpochMilli(endTime.getTime());
        //相差秒数
        Long seconds = Duration.between(startTimeIn, endTimeIn).getSeconds();
        return seconds;
    }

    public Long getInstant(String startTime, String endTime) {
        try {
            return getInstant(DateUtils.parseDate(startTime, "yyyy-MM-dd HH:mm:ss"), DateUtils.parseDate(endTime, "yyyy-MM-dd HH:mm:ss"));
        } catch (ParseException e) {
            e.printStackTrace();
            log.error("时间类型转换异常");
        }
        return null;
    }

    public Integer instantType(Long seconds) {
        if (seconds < MIN_SECOND || seconds > MAX_SECOND) {
            throw new DateTimeException("instantType exceeds minimum or maximum instant");
        }
        //年，月,日
        if (2 * Consts.secondOfMonth < seconds) {
            return YEAR;
        } else if (2 * Consts.secondOfDay < seconds) {
            return MONTH;

        } else if (2 * Consts.secondOfHour < seconds) {
            return DAY;
        }
        return 0;
    }
}
