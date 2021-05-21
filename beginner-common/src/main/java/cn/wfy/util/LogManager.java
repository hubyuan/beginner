package cn.wfy.util;


public class LogManager {

    public static LogUtil getLogger() {
        ThreadLocal<LogUtil> local = new ThreadLocal();
        LogUtil logUtil = local.get();
        if (logUtil == null) {
            logUtil = new LogUtil();
            local.set(logUtil);
        }
        return logUtil;
    }
}
