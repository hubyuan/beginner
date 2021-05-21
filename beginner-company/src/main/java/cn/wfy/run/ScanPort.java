package cn.wfy.run;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class ScanPort extends JFrame {
    /**
     * 端口扫描启动主程序
     */
    private static final long serialVersionUID = 1L;
    String str1 = " 常见端口有:";
    String str2 = "ftp:21,22,telnet:23,smtp:25,http:80";
    String str3 = "dns:53,tftp:69,snmp:161,162";
    String str4 = "1158,1433,1521,2100,3128,26,69";
    String str5 = "3306,3389,7001,8080,8081,110,143";
    String str6 = "9080,9090,43958,443,465,995,1080";
    JButton jb1 = new JButton("strat");
    JTextArea jta = new JTextArea();
    JScrollPane jsp = new JScrollPane(jta);
    JTextField jtf = new JTextField(17);
    String IP = "";//待扫描IP或域名
    List <Integer>portList = new LinkedList<Integer>();// 定义一个List容器表示扫描的团口的List集合
    Integer[] ports = new Integer[] { 21, 22, 23, 25, 26, 53,69, 80, 110, 143,
            443,465,69,161,162,135,995,1080,1158,1433,1521,2100, 3128, 3306, 3389,
            7001, 8080, 8081, 9080, 9090, 43958 ,135,445,1025,1026,1027,1028,1055,5357};
    // 常见端口集合
    public ScanPort() {
        this.add(getPanel(), BorderLayout.SOUTH);
        jsp.setBorder(BorderFactory.createEtchedBorder());
        jsp.setBackground(Color.cyan);
        this.add(jsp, BorderLayout.CENTER);
        this.add(getPanel2(), BorderLayout.NORTH);
        this.add(getPanel3(), BorderLayout.WEST);
        this.setBounds(300, 60, 600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ScanPort");
        jta.setTabSize(4);
        jta.setFont(new Font("标楷体", Font.BOLD, 16));
        jta.setLineWrap(true);// 激活自动换行功能
        jta.setWrapStyleWord(true);// 激活断行不断字功能
        portList.addAll(Arrays.asList(ports));
        //将ports中的值加入到set中，并去掉重复的
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                IP = jta.getText();
                //ip为文本框内输入的字符串
                scanPorts(IP, portList, 10, 800);
                //超时时间设定为800，线程数设定为10
            }
        });
        this.setVisible(true);
    }
    /**
     * 多线程扫描目标主机指定List端口集合的开放情况
     *
     * @param ip
     *   待扫描IP或域名
     * @param portList
     *   待扫描的端口的List集合
     * @param threadNumber
     *   线程数
     * @param timeout
     *   连接超时时间
     * */
    public void scanPorts(String ip, List<Integer> portSet,int threadNumber, int timeout) {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        //线程池
        for (int i = 0; i < threadNumber; i++) {
            //10个线程 加入到线程池里
            ScanMethod scanMethod2 = new ScanMethod(ip, portSet,threadNumber, i, timeout);
            threadPool.execute(scanMethod2);
        }
        threadPool.shutdown();
        while (true) {
            if (threadPool.isTerminated()) {
                System.out.println("扫描结束");
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }// end of while
    }
    /*
     * 扫描方式：针对一个待扫描的端口的List集合进行扫描
     */
    private class ScanMethod implements Runnable {
        private String ip; // 目标IP
        private List<Integer> portList; // 待扫描的端口的List集合
        private int threadNumber, serial, timeout; // 线程数，这是第几个线程，超时时间
        public ScanMethod(String ip, List<Integer> portList, int threadNumber,int serial, int timeout) {
            this.ip = ip;
            this.portList = portList;
            this.threadNumber = threadNumber;
            this.serial = serial;
            this.timeout = timeout;
        }
        public void run() {
            int port = 0;
            Integer[] ports = portList.toArray(new Integer[portList.size()]); // List转数组
            try {
                InetAddress address = InetAddress.getByName(ip); //如果输入的是主机名，尝试获取ip地址
                Socket socket;//定义套接字
                SocketAddress socketAddress;//传递ip和端口
                if (ports.length < 1)
                    //若数组没有元素，返回，不执行
                    return;
                for (port = 0 + serial; port <= ports.length - 1; port += threadNumber) {
                    //每次运行10个线程
                    socket = new Socket();
                    //为对象分配内存空间
                    socketAddress = new InetSocketAddress(address, ports[port]);
                    try {
                        socket.connect(socketAddress, timeout);
                        //对目标主机的指定端口进行连接，超时后连接失败
                        socket.close();
                        //关闭端口
                        System.out.println("端口 " + ports[port] + " ：开放");
                        jta.append("端口 " + ports[port] + " ：开放\n");
                        //在文本区域里更新消息
                    } catch (IOException e) {
                        System.out.println("端口 " + ports[port] + " ：关闭");
                        jta.append("端口 " + ports[port] + " ：关闭\n");
                        //产生异常表示端口关闭
                    }
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        //end of run()
    }//end of ScanMethod
    public JPanel getPanel() {
        JPanel jp = new JPanel();
        jp.add(jb1, BorderLayout.CENTER);
        jp.setBorder(BorderFactory.createRaisedBevelBorder());
        jp.setBackground(Color.lightGray);
        return jp;
    }
    public JPanel getPanel2() {
        JPanel jp = new JPanel();
        JLabel jl = new JLabel();
        jl.setText("请输入主机名或ip地址，将扫描该主机的常见端口号：");
        jp.add(jl);
        jp.add(jtf);
        jp.setBorder(BorderFactory.createRaisedBevelBorder());
        jp.setBackground(Color.LIGHT_GRAY);
        return jp;
    }
    public JPanel getPanel3() {
        JLabel jl1 = new JLabel(str1);
        JLabel jl2 = new JLabel(str2);
        JLabel jl3 = new JLabel(str3);
        JLabel jl4 = new JLabel(str4);
        JLabel jl5 = new JLabel(str5);
        JLabel jl6 = new JLabel(str6);
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(6, 1));
        jp.add(jl1);
        jp.add(jl2);
        jp.add(jl3);
        jp.add(jl4);
        jp.add(jl5);
        jp.add(jl6);
        jp.setBorder(BorderFactory.createEtchedBorder());
        //蚀刻边框
        return jp;
    }
    public static void main(String[] args) {
        new ScanPort();
    }
}

