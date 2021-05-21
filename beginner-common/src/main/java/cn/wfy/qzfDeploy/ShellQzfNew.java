package cn.wfy.qzfDeploy;


import cn.wfy.vo.MyUserInfo;
import com.jcraft.jsch.*;
import org.apache.tomcat.util.bcel.Const;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ShellQzfNew {
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
    public static final String ssh_sh = "/home/abc/program/update/ssh1.sh";
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

    public ShellQzfNew() {
    }

    /**
     * 初始化登录信息
     *
     * @param ip
     * @param username
     * @param password
     */
    public ShellQzfNew(String ip, String username, String password, int sshPort) {
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


        ShellQzfNew shell = new ShellQzfNew(IP, "abc", normal_password, 40071);
//        shell.execute("uname -s -r -v");
        int ls = shell.execute("aaa");
//        shell.execute("scp 2.zip ");
        System.out.println(ls);
        ArrayList<String> stdout = shell.getStandardOutput();
        for (String str : stdout) {
            System.out.println(str);
        }
    }*/

    public Integer getA1() {
        return a1;
    }

    public void setA1(Integer a1) {
        this.a1 = a1;
    }

    public Integer getB1() {
        return b1;
    }

    public void setB1(Integer b1) {
        this.b1 = b1;
    }

    public Integer getC1() {
        return c1;
    }

    public void setC1(Integer c1) {
        this.c1 = c1;
    }

    public Integer getD1() {
        return d1;
    }

    public void setD1(Integer d1) {
        this.d1 = d1;
    }

    public Integer getE1() {
        return e1;
    }

    public void setE1(Integer e1) {
        this.e1 = e1;
    }

    public Integer getF1() {
        return f1;
    }

    public void setF1(Integer f1) {
        this.f1 = f1;
    }

    public ShellQzfNew(Integer a1, Integer b1, Integer c1, Integer d1, Integer e1, Integer f1) {
        this.a1 = a1;
        this.b1 = b1;
        this.c1 = c1;
        this.d1 = d1;
        this.e1 = e1;
        this.f1 = f1;
    }

    public ShellQzfNew(Integer a1) {
        this.a1 = a1;
    }

    @returnNum()
    public Integer[] vueUpdateAll(String destName, String fileName, boolean exec) {

        String srcName = destName + "/" + fileName;
        //linux 到linux
        ShellQzfNew shell = new ShellQzfNew(IP, "abc", normal_password, 40071);


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
            a1 = shell.execute(ssh_sh + " " + KDL_IP + " " + dell_usernameAndpass + " \"unzip -oq " + kdlweb_path + "/" + fileName + " -d " + kdlweb_path + "\"");
            //凯通
            b1 = shell.execute(ssh_sh + " " + KTL_IP + " " + dell_usernameAndpass + " \"unzip -oq " + ktlweb_path + "/" + fileName + " -d " + ktlweb_path + "\"");

            //人武
            c1 = shell.execute(ssh_sh + " " + RWRFL_IP + " " + dell_usernameAndpass + " \"unzip -oq " + ktlweb_path + "/" + fileName + " -d " + ktlweb_path + "\"");

            //加压站
            d1 = shell.execute(ssh_sh + " " + JYZ_IP + " " + dell_usernameAndpass + " \"unzip -oq " + ktlweb_path + "/" + fileName + " -d " + ktlweb_path + "\"");

            //中心系统
            e1 = shell.execute(ssh_sh + " " + QZF_IP1 + " " + abc_usernameAndpass + " \"unzip -oq " + centerweb_path + "/" + fileName + " -d " + centerweb_path + "\"");


            //行政中心
            f1 = shell.execute("mv " + center_path + "/" + fileName + " " + centerweb_path);
            f1 = shell.execute("unzip -oq " + centerweb_path + "/" + fileName + " -d " + centerweb_path);
        }

        printResult(new Integer[]{a1, b1, c1, d1, e1, f1});
        return new Integer[]{a1, b1, c1, d1, e1, f1};
    }

    public Integer[] springUpdateAll(String destName, String fileName) {
        return springUpdateAll(destName, fileName, false);
    }

    @returnNum()
    public Integer[] springUpdateAll(String destName, String fileName, boolean excute) {

        int i = 0;
        String srcName = destName + "/" + fileName;
        //linux 到linux
        ShellQzfNew shell = new ShellQzfNew(IP, "abc", normal_password, 40071);

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
            a1 = shell.execute(ssh_sh + " " + KDL_IP + " " + dell_usernameAndpass + " \"" + kdl_path + "/shell.sh up \"");
            //凯通
            b1 = shell.execute(ssh_sh + " " + KTL_IP + " " + dell_usernameAndpass + " \"" + ktl_path + "/shell.sh up \"");

            //人武
            c1 = shell.execute(ssh_sh + " " + RWRFL_IP + " " + dell_usernameAndpass + " \"" + ktl_path + "/shell.sh up \"");

            //加压站
            d1 = shell.execute(ssh_sh + " " + JYZ_IP + " " + dell_usernameAndpass + " \"" + ktl_path + "/shell.sh up \"");

            //中心系统
            e1 = shell.execute(ssh_sh + " " + QZF_IP1 + " " + abc_usernameAndpass + " \"" + center_path + "/shell.sh up \"");

            //行政中心
            f1 = shell.execute(center_path + "/shell.sh up");

        }
        printResult(new Integer[]{a1, b1, c1, d1, e1, f1});
        return new Integer[]{a1, b1, c1, d1, e1, f1};
    }

    Integer a1;
    Integer b1;
    Integer c1;
    Integer d1;
    Integer e1;
    Integer f1;


    //测试可用
    @returnNum()
    public Integer[] cleanAll() {

        ShellQzfNew shell = new ShellQzfNew(IP, "abc", normal_password, 40071);

        //凯达
        a1 = shell.execute(ssh_sh + " " + KDL_IP + " " + dell_usernameAndpass + " \"" + kdl_path + "/shell.sh clean \"");
        //凯通
        b1 = shell.execute(ssh_sh + " " + KTL_IP + " " + dell_usernameAndpass + " \"" + ktl_path + "/shell.sh clean \"");

        //人武
        c1 = shell.execute(ssh_sh + " " + RWRFL_IP + " " + dell_usernameAndpass + " \"" + ktl_path + "/shell.sh clean \"");

        //加压站
        d1 = shell.execute(ssh_sh + " " + JYZ_IP + " " + dell_usernameAndpass + " \"" + ktl_path + "/shell.sh clean \"");

        //中心系统
        e1 = shell.execute(ssh_sh + " " + QZF_IP1 + " " + abc_usernameAndpass + " \"" + center_path + "/shell.sh clean \"");

        //行政中心
        f1 = shell.execute(center_path + "/shell.sh clean");
        printResult(new Integer[]{a1, b1, c1, d1, e1, f1});
        return new Integer[]{a1, b1, c1, d1, e1, f1};
    }


    //测试可用
    @returnNum()
    public Integer[] sqlUpdateAll(String destName, String fileName, boolean exec) {

        String srcName = destName + "/" + fileName;
        //linux 到linux
        ShellQzfNew shell = new ShellQzfNew(IP, "abc", normal_password, 40071);

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
            a1 = shell.execute(ssh_sh + " " + KDL_IP + " " + dell_usernameAndpass + " \"" + kdl_path + "/shell.sh updatemysql \"");
            //凯通
            b1 = shell.execute(ssh_sh + " " + KTL_IP + " " + dell_usernameAndpass + " \"" + ktl_path + "/shell.sh updatemysql \"");

            //人武
            c1 = shell.execute(ssh_sh + " " + RWRFL_IP + " " + dell_usernameAndpass + " \"" + ktl_path + "/shell.sh updatemysql \"");

            //加压站
            d1 = shell.execute(ssh_sh + " " + JYZ_IP + " " + dell_usernameAndpass + " \"" + ktl_path + "/shell.sh updatemysql \"");

            //中心系统
//            e1 = shell.execute(ssh_sh + " " + QZF_IP1 + " " + abc_usernameAndpass + " \"" + center_path + "/shell.sh updatemysql \"");

            //行政中心
            f1 = shell.execute(center_path + "/shell.sh updatemysql");

        }
        printResult(new Integer[]{a1, b1, c1, d1, 1, f1});
        return new Integer[]{a1, b1, c1, d1, 1, f1};
    }


    public void printResult(Integer[] args) {
        for (int i = 0; i < args.length; i++) {
            if (i == 0) {
                if (args[i] == 0) {
                    System.out.println("凯达成功");

                } else {
                    System.out.println("凯达失败");

                }
            }
            if (i == 1) {
                if (args[i] == 0) {
                    System.out.println("凯通成功");

                } else {
                    System.out.println("凯通失败");

                }
            }
            if (i == 2) {
                if (args[i] == 0) {
                    System.out.println("人武成功");

                } else {
                    System.out.println("人武失败");

                }
            }
            if (i == 3) {
                if (args[i] == 0) {
                    System.out.println("加压站成功");

                } else {
                    System.out.println("加压站失败");

                }
            }
            if (i == 4) {
                if (args[i] == 0) {
                    System.out.println("中心系统成功");

                } else {
                    System.out.println("中心系统失败");

                }
            }
            if (i == 5) {
                if (args[i] == 0) {
                    System.out.println("行政中心成功");

                } else {
                    System.out.println("行政中心失败");

                }
            }

        }
    }


    //可用 path: /ems-zuul

    /***
     *
     * @param destName 数据中心文件地址 exp：/home/abc/program/qzf
     * @param fileName  as you know
     * @param path exp： /ems-zuul-exec
     * @param rmFileName exp: application-routes-file.yml
     */
    public void replaceFile(String destName, String fileName, String path, String rmFileName) {


        ShellQzfNew shell = new ShellQzfNew(IP, "abc", normal_password, 40071);

        //凯达
        a1 = shell.execute(ssh_sh + " " + KDL_IP + " " + dell_usernameAndpass + " \" rm " + kdl_path + path + "/" + rmFileName + " \"");
        //凯通
        b1 = shell.execute(ssh_sh + " " + KTL_IP + " " + dell_usernameAndpass + " \" rm " + ktl_path + path + "/" + rmFileName + " \"");

        //人武
        c1 = shell.execute(ssh_sh + " " + RWRFL_IP + " " + dell_usernameAndpass + " \" rm " + ktl_path + path + "/" + rmFileName + " \"");

        //加压站
        d1 = shell.execute(ssh_sh + " " + JYZ_IP + " " + dell_usernameAndpass + " \" rm " + ktl_path + path + "/" + rmFileName + " \"");

        //中心系统
        e1 = shell.execute(ssh_sh + " " + QZF_IP1 + " " + abc_usernameAndpass + " \" rm " + center_path + path + "/" + rmFileName + " \"");

        //行政中心
        f1 = shell.execute(" rm " + center_path + path + "/" + rmFileName + " \"");


        String srcName = destName + "/" + fileName;
        //linux 到linux
        shell = new ShellQzfNew(IP, "abc", normal_password, 40071);
        //凯达
        int a = shell.execute(scp_sh + " " + KDL_IP + " " + dell_usernameAndpass + " " + srcName + " " + kdl_path + path);
        //凯通
        int b = shell.execute(scp_sh + " " + KTL_IP + " " + dell_usernameAndpass + " " + srcName + " " + ktl_path+ path);

        //人武
        int c = shell.execute(scp_sh + " " + RWRFL_IP + " " + dell_usernameAndpass + " " + srcName + " " + ktl_path+ path);

        //加压站
        int d = shell.execute(scp_sh + " " + JYZ_IP + " " + dell_usernameAndpass + " " + srcName + " " + ktl_path+ path);
        //中心系统
        int e = shell.execute(scp_sh + " " + QZF_IP1 + " " + abc_usernameAndpass + " " + srcName + " " + center_path+ path);

    }

    //测试可用
    @returnNum()
    public Integer[] command(String command) {

        ShellQzfNew shell = new ShellQzfNew(IP, "abc", normal_password, 40071);

        //凯达
        a1 = shell.execute(ssh_sh + " " + KDL_IP + " " + dell_usernameAndpass + " \"" + kdl_path + "/shell.sh " + command + " \"");
        //凯通
        b1 = shell.execute(ssh_sh + " " + KTL_IP + " " + dell_usernameAndpass + " \"" + ktl_path + "/shell.sh " + command + " \"");

        //人武
        c1 = shell.execute(ssh_sh + " " + RWRFL_IP + " " + dell_usernameAndpass + " \"" + ktl_path + "/shell.sh " + command + " \"");

        //加压站
        d1 = shell.execute(ssh_sh + " " + JYZ_IP + " " + dell_usernameAndpass + " \"" + ktl_path + "/shell.sh " + command + " \"");

        //中心系统
        e1 = shell.execute(ssh_sh + " " + QZF_IP1 + " " + abc_usernameAndpass + " \"" + center_path + "/shell.sh " + command + " \"");

        //行政中心
        f1 = shell.execute(center_path + "/shell.sh " + command + " \"");
        printResult(new Integer[]{a1, b1, c1, d1, e1, f1});
        return new Integer[]{a1, b1, c1, d1, e1, f1};

    }

    //测试可用
    @returnNum()
    public Integer[] justcommand(String command) {

        ShellQzfNew shell = new ShellQzfNew(IP, "abc", normal_password, 40071);

        //凯达
        a1 = shell.execute(ssh_sh + " " + KDL_IP + " " + dell_usernameAndpass + " \"" + kdl_path + "/shell.sh " + command + " \"");
        //凯通
        b1 = shell.execute(ssh_sh + " " + KTL_IP + " " + dell_usernameAndpass + " \"" + ktl_path + "/shell.sh " + command + " \"");

        //人武
        c1 = shell.execute(ssh_sh + " " + RWRFL_IP + " " + dell_usernameAndpass + " \"" + ktl_path + "/shell.sh " + command + " \"");

        //加压站
        d1 = shell.execute(ssh_sh + " " + JYZ_IP + " " + dell_usernameAndpass + " \"" + ktl_path + "/shell.sh " + command + " \"");

        //中心系统
        e1 = shell.execute(ssh_sh + " " + QZF_IP1 + " " + abc_usernameAndpass + " \"" + center_path + "/shell.sh " + command + " \"");

        //行政中心
        f1 = shell.execute(center_path + "/shell.sh " + command + " \"");
        printResult(new Integer[]{a1, b1, c1, d1, e1, f1});
        return new Integer[]{a1, b1, c1, d1, e1, f1};

    }

}

