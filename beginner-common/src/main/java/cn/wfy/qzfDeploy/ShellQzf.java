package cn.wfy.qzfDeploy;


import cn.wfy.vo.MyUserInfo;
import com.jcraft.jsch.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ShellQzf {
    public static final String IP = "192.168.6.110";
    public static final String KDL_IP = "172.23.39.74";
    public static final String KTL_IP = "172.23.39.70";
    public static final String RWRFL_IP = "172.23.39.78";
    public static final String JYZ_IP = "172.23.39.82";
    public static final String QZF_IP = "172.23.39.66";
    public static final String QZF_IP1 = "10.10.10.3";

    public static final String dell_usernameAndpass = "dell abc@123456";
    public static final String abc_usernameAndpass = "abc abc@123456";
    public static final String kdlweb_path = "/home/dell/qzfweb";
    public static final String ktlweb_path = "/home/dell/programs/qzfweb";
    public static final String centerweb_path = "/home/abc/program/qzfweb";
    public static final String scp_sh = "/home/abc/program/update/scp1.sh";
    public static final String normal_password = "abc@123456";
    public static final String ktl_path = "/home/dell/programs/qzf";
    public static final String kdl_path = "/home/dell/qzf";
    public static final String center_path = "/home/abc/program/qzf";


    //远程主机的ip地址
    private String ip;
    //远程主机登录用户名
    private String username;
    //远程主机的登录密码
    private String password;
    //设置ssh连接的远程端口
    public int sshPort;
    //保存输出内容的容器
    private ArrayList<String> stdout;

    public ShellQzf() {
    }

    /**
     * 初始化登录信息
     *
     * @param ip
     * @param username
     * @param password
     */
    public ShellQzf(String ip, String username, String password, int sshPort) {
        this.ip = ip;
        this.username = username;
        this.password = password;
        this.sshPort = sshPort;
        stdout = new ArrayList<String>();
    }

    /**
     * 执行shell命令
     *
     * @param command
     * @return
     */
    public int execute(final String command) {
        int returnCode = 0;
        JSch jsch = new JSch();
        MyUserInfo userInfo = new MyUserInfo();

        try {
            //创建session并且打开连接，因为创建session之后要主动打开连接
            Session session = jsch.getSession(username, ip, sshPort);
            session.setPassword(password);
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setUserInfo(userInfo);
            session.connect();

            //打开通道，设置通道类型，和执行的命令
            Channel channel = session.openChannel("exec");
            ChannelExec channelExec = (ChannelExec) channel;
            channelExec.setCommand(command);

            channelExec.setInputStream(null);
            BufferedReader input = new BufferedReader(new InputStreamReader
                    (channelExec.getInputStream()));

            channelExec.connect();
            System.out.println("The remote command is :" + command);

            //接收远程服务器执行命令的结果
            String line;
            while ((line = input.readLine()) != null) {
                stdout.add(line);
            }
            input.close();

            // 得到returnCode
            if (channelExec.isClosed()) {
                returnCode = channelExec.getExitStatus();
            }

            // 关闭通道
            channelExec.disconnect();
            //关闭session
            session.disconnect();

        } catch (JSchException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnCode;
    }

    /**
     * get stdout
     *
     * @return
     */
    public ArrayList<String> getStandardOutput() {
        return stdout;
    }

   /* public static void main(final String[] args) {


        ShellQzf shell = new ShellQzf(IP, "abc", normal_password, 40071);
//        shell.execute("uname -s -r -v");
        int ls = shell.execute("aaa");
//        shell.execute("scp 2.zip ");
        System.out.println(ls);
        ArrayList<String> stdout = shell.getStandardOutput();
        for (String str : stdout) {
            System.out.println(str);
        }
    }*/


    public void vueUpdateAll(String destName, String fileName,boolean exec) {

        String srcName = destName + "/" + fileName;
        //linux 到linux
        ShellQzf shell = new ShellQzf(IP, "abc", normal_password, 40071);


        //凯达
        int a = shell.execute(scp_sh + " " + KDL_IP + " " + dell_usernameAndpass + " " + srcName + " " + kdlweb_path);
        //凯通
        int b = shell.execute(scp_sh + " " + KTL_IP + " " + dell_usernameAndpass + " " + srcName + " " + ktlweb_path);

        //人武
        int c = shell.execute(scp_sh + " " + RWRFL_IP + " " + dell_usernameAndpass + " " + srcName + " " + ktlweb_path);

        //加压站
        int d = shell.execute(scp_sh + " " + JYZ_IP + " " + dell_usernameAndpass + " " + srcName + " " + ktlweb_path);

        //中心系统
        int e = shell.execute(scp_sh + " " + QZF_IP1 + " " + abc_usernameAndpass + " " + srcName + " " + centerweb_path);

//        int i = 0;
        int i = a + b + c + d + e;
        if (i == 0) {
            System.out.println(srcName + "成功上传！");
        } else {
            System.out.println(srcName + "上传失败！");

        }

        if (exec) {
            //凯达
            try {
                shell = new ShellQzf(IP, "dell", normal_password, 40041);
                shell.execute("unzip -oq " + kdlweb_path + "/" + fileName + " -d " + kdlweb_path);
                System.out.println("凯达vue静态文件更新成功");
            } catch (Exception e1) {
                e1.printStackTrace();
                System.out.println("凯达vue静态文件更新失败");

            }

            //凯通
            shell = new ShellQzf(IP, "dell", normal_password, 40061);
            shell.execute("unzip -oq " + ktlweb_path + "/" + fileName + " -d " + ktlweb_path);
            System.out.println("凯通vue静态文件更新成功");

            //人武
            shell = new ShellQzf(IP, "dell", normal_password, 40051);
            shell.execute("unzip -oq " + ktlweb_path + "/" + fileName + " -d " + ktlweb_path);
            System.out.println("人武vue静态文件更新成功");

            //加压站
            shell = new ShellQzf(IP, "dell", normal_password, 40091);
            shell.execute("unzip -oq " + ktlweb_path + "/" + fileName + " -d " + ktlweb_path);
            System.out.println("加压站vue静态文件更新成功");

            //中心系统
            shell = new ShellQzf(IP, "abc", normal_password, 40077);
            shell.execute("unzip -oq " + centerweb_path + "/" + fileName + " -d " + centerweb_path);
            System.out.println("中心系统vue静态文件更新成功");

            //行政楼
            shell = new ShellQzf(IP, "abc", normal_password, 40071);
            shell.execute("unzip -oq " + centerweb_path + "/" + fileName + " -d " + centerweb_path);
            System.out.println("行政楼vue静态文件更新成功");


        }

    }

    public void springUpdateAll(String destName, String fileName) {
        springUpdateAll(destName,fileName,false);
    }
    public void springUpdateAll(String destName, String fileName,boolean excute) {

        int i = 0;
        String srcName = destName + "/" + fileName;
        //linux 到linux
        ShellQzf shell = new ShellQzf(IP, "abc", normal_password, 40071);

        //凯达
        int a = shell.execute(scp_sh + " " + KDL_IP + " " + dell_usernameAndpass + " " + srcName + " " + kdl_path);
        //凯通
        int b = shell.execute(scp_sh + " " + KTL_IP + " " + dell_usernameAndpass + " " + srcName + " " + ktl_path);

        //人武
        int c = shell.execute(scp_sh + " " + RWRFL_IP + " " + dell_usernameAndpass + " " + srcName + " " + ktl_path);

        //加压站
       int d = shell.execute(scp_sh + " " + JYZ_IP + " " + dell_usernameAndpass + " " + srcName + " " + ktl_path);

        //中心系统
        int e = shell.execute(scp_sh + " " + QZF_IP1 + " " + abc_usernameAndpass + " " + srcName + " " + center_path);

//        i = a + b + c + d + e;

        if (i == 0) {
            System.out.println(srcName + "成功上传！");
        } else {
            System.out.println(srcName + "上传失败！");

        }

        if (excute) {
            //凯达
           shell = new ShellQzf(IP, "dell", normal_password, 40041);
            shell.execute(kdl_path + "/shell.sh up");
            System.out.println("凯达jar更新成功");
//            //凯通
            shell = new ShellQzf(IP, "dell", normal_password, 40061);
            shell.execute(ktl_path + "/shell.sh up");
            System.out.println("凯通jar更新成功");

            //人武
           shell = new ShellQzf(IP, "dell", normal_password, 40051);
            shell.execute(ktl_path + "/shell.sh up");
            System.out.println("人武jar更新成功");

            //加压站
            shell = new ShellQzf(IP, "dell", normal_password, 40091);
            shell.execute(ktl_path + "/shell.sh up");
            System.out.println("加压站jar更新成功");
//
//            //中心系统
            shell = new ShellQzf(IP, "abc", normal_password, 40077);
            shell.execute(center_path + "/shell.sh up");
            System.out.println("中心系统jar更新成功");

            //行政楼
            shell = new ShellQzf(IP, "abc", normal_password, 40071);
            shell.execute(center_path + "/shell.sh up");
            System.out.println("行政楼jar更新成功");
        }

    }


    //测试可用
    public void cleanAll() {
        ShellQzf shell = null;
        //凯达
        shell = new ShellQzf(IP, "dell", normal_password, 40041);
        shell.execute(kdl_path + "/shell.sh clean");
        System.out.println("凯达clean成功");

        //凯通
        shell = new ShellQzf(IP, "dell", normal_password, 40061);
        shell.execute(ktl_path + "/shell.sh clean");
        System.out.println("凯通clean成功");

        //人武
        shell = new ShellQzf(IP, "dell", normal_password, 40051);
        shell.execute(ktl_path + "/shell.sh clean");
        System.out.println("人武clean成功");

        //加压站
        shell = new ShellQzf(IP, "dell", normal_password, 40091);
        shell.execute(ktl_path + "/shell.sh clean");
        System.out.println("加压站clean成功");

        //中心系统
        shell = new ShellQzf(IP, "abc", normal_password, 40077);
        shell.execute(center_path + "/shell.sh clean");
        System.out.println("中心系统clean成功");

        //行政中心
        shell = new ShellQzf(IP, "abc", normal_password, 40071);
        shell.execute(center_path + "/shell.sh clean");
        System.out.println("行政中心clean成功");

    }


    //测试可用
    public void sqlUpdateAll(String destName, String fileName,boolean exec) {

        String srcName = destName + "/" + fileName;
        //linux 到linux
        ShellQzf shell = new ShellQzf(IP, "abc", normal_password, 40071);

        //凯达
        int a = shell.execute(scp_sh + " " + KDL_IP + " " + dell_usernameAndpass + " " + srcName + " " + kdl_path);
        //凯通
        int b = shell.execute(scp_sh + " " + KTL_IP + " " + dell_usernameAndpass + " " + srcName + " " + ktl_path);

        //人武
        int c = shell.execute(scp_sh + " " + RWRFL_IP + " " + dell_usernameAndpass + " " + srcName + " " + ktl_path);

        //加压站
        int d = shell.execute(scp_sh + " " + JYZ_IP + " " + dell_usernameAndpass + " " + srcName + " " + ktl_path);

        //中心系统
        int e = shell.execute("/home/abc/program/update/scp1.sh 172.23.39.66 abc abc@123456 " + srcName + " /home/abc/program/qzf");

        int i = a + b + c + d;
        if (i == 0) {
            System.out.println(srcName + "成功上传！");
        } else {
            System.out.println(srcName + "上传失败！");

        }

        if (exec) {

            //凯达
            shell = new ShellQzf("192.168.6.110", "dell", normal_password, 40041);
            shell.execute(kdl_path + "/shell.sh updatemysql");
            System.out.println("凯达sql更新成功");

            //凯通
            shell = new ShellQzf("192.168.6.110", "dell", normal_password, 40061);
            shell.execute(ktl_path + "/shell.sh updatemysql");
            System.out.println("凯通sql更新成功");

            //人武
            shell = new ShellQzf("192.168.6.110", "dell", normal_password, 40051);
            shell.execute(ktl_path + "/shell.sh updatemysql");
            System.out.println("人武sql更新成功");

            //加压站
            shell = new ShellQzf(IP, "dell", normal_password, 40091);
            shell.execute(ktl_path + "/shell.sh updatemysql");
            System.out.println("加压站sql更新成功");

            //行政楼
            shell = new ShellQzf(IP, "abc", normal_password, 40071);
            shell.execute(center_path + "/shell.sh updatemysql");
            System.out.println("行政楼sql更新成功");
/*
            //中心系统
            shell = new ShellQzf("192.168.6.110", "abc", "abc@123456", 40077);
            shell.execute("/home/abc/program/qzf/shell.sh updatemysql");
            shell.execute("/home/abc/program/qzf/shell.sh clean");
            System.out.println("中心系统sql更新成功");
*/

        }

    }


    //测试可用
    public void shellUpdateAll(String destName, String fileName) {

        ShellQzf shell = null;

        //凯达
        shell = new ShellQzf(IP, "dell", normal_password, 40041);
        shell.execute("rm " + kdl_path + "/shell.sh");

        //凯通
        shell = new ShellQzf(IP, "dell", normal_password, 40061);
        shell.execute("rm " + ktl_path + "/shell.sh");

        //人武
        shell = new ShellQzf(IP, "dell", normal_password, 40051);
        shell.execute("rm " + ktl_path + "/shell.sh");

        //加压站
        shell = new ShellQzf(IP, "dell", normal_password, 40091);
        shell.execute("rm " + ktl_path + "/shell.sh");

        //中心系统
        shell = new ShellQzf(IP, "abc", normal_password, 40077);
        shell.execute("rm " + center_path + "/shell.sh");


        String srcName = destName + "/" + fileName;
        //linux 到linux
        shell = new ShellQzf(IP, "abc", normal_password, 40071);
        //凯达
        int a = shell.execute(scp_sh + " " + KDL_IP + " " + dell_usernameAndpass + " " + srcName + " " + kdl_path);
        //凯通
        int b = shell.execute(scp_sh + " " + KTL_IP + " " + dell_usernameAndpass + " " + srcName + " " + ktl_path);

        //人武
        int c = shell.execute(scp_sh + " " + RWRFL_IP + " " + dell_usernameAndpass + " " + srcName + " " + ktl_path);

        //加压站
        int d = shell.execute(scp_sh + " " + JYZ_IP + " " + dell_usernameAndpass + " " + srcName + " " + ktl_path);

        //中心系统
        int e = shell.execute(scp_sh + " " + QZF_IP1 + " " + abc_usernameAndpass + " " + srcName + " " + center_path);

        int i = a + b + c + d + e;
        if (i == 0) {
            System.out.println(srcName + "成功上传！");
        } else {
            System.out.println(srcName + "上传失败！");

        }

        if (i == 0) {

            //凯达
            shell = new ShellQzf(IP, "dell", normal_password, 40041);
            shell.execute("chmod +x " + kdl_path + "/shell.sh");
            System.out.println("凯达sql更新成功");

            //凯通
            shell = new ShellQzf(IP, "dell", normal_password, 40061);
            shell.execute("chmod +x " + ktl_path + "/shell.sh");
            System.out.println("凯通sql更新成功");

            //人武
            shell = new ShellQzf(IP, "dell", normal_password, 40051);
            shell.execute("chmod +x " + ktl_path + "/shell.sh");
            System.out.println("人武sql更新成功");

            //加压站
            shell = new ShellQzf(IP, "dell", normal_password, 40091);
            shell.execute("chmod +x " + ktl_path + "/shell.sh");
            System.out.println("加压站sql更新成功");

            //中心系统
            shell = new ShellQzf(IP, "abc", normal_password, 40077);
            shell.execute("chmod +x " + center_path + "/shell.sh");
            System.out.println("中心系统sql更新成功");


        }

    }

    //测试可用
    public void command(String command) {
        ArrayList<String> standardOutput = null;
        ShellQzf shell = null;
        //凯达
        shell = new ShellQzf(IP, "dell", normal_password, 40041);
        shell.execute(kdl_path + "/shell.sh " + command);
        standardOutput = shell.getStandardOutput();
        System.out.println("凯达");
        standardOutput.forEach(System.out::println);

        //凯通
        shell = new ShellQzf(IP, "dell", normal_password, 40061);
        shell.execute(ktl_path + "/shell.sh " + command);
        standardOutput = shell.getStandardOutput();
        System.out.println("凯通");
        standardOutput.forEach(System.out::println);

        //人武
        shell = new ShellQzf(IP, "dell", normal_password, 40051);
        shell.execute(ktl_path + "/shell.sh " + command);
        standardOutput = shell.getStandardOutput();
        System.out.println("人武");
        standardOutput.forEach(System.out::println);

        //加压站
        shell = new ShellQzf(IP, "dell", normal_password, 40091);
        shell.execute(ktl_path + "/shell.sh " + command);
        standardOutput = shell.getStandardOutput();
        System.out.println("加压站");
        standardOutput.forEach(System.out::println);

        //中心系统
        shell = new ShellQzf(IP, "abc", normal_password, 40077);
        shell.execute(center_path + "/shell.sh " + command);
        standardOutput = shell.getStandardOutput();
        System.out.println("中心系统");
        standardOutput.forEach(System.out::println);

        //行政中心
        shell = new ShellQzf(IP, "abc", normal_password, 40071);
        shell.execute(center_path + "/shell.sh " + command);
        standardOutput = shell.getStandardOutput();
        System.out.println("行政中心");
        standardOutput.forEach(System.out::println);

    }


}

