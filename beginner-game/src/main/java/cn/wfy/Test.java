package cn.wfy;

import com.alibaba.fastjson.JSONArray;

import javax.swing.*;
import java.awt.*;
import java.io.*;


/**
 * @Description TODO
 * @auther wfy
 * @since 2020/10/5
 */
public class Test {
    private JFrame jFrame;
    private JButton jButton1,jButton2,jButton3;
    public static void main(String[] args) throws FileNotFoundException {
        JSONArray jsonArray=new JSONArray();
        jsonArray.add(1);
        jsonArray.add(2);
        jsonArray.add(3);
        jsonArray.add(4);
        System.out.println(jsonArray);
        jsonArray.set(0,12);
        System.out.println(jsonArray);
    }

    private void go() {
        jButton1= new JButton("North");
        jButton2 = new JButton("Center");
        jButton3= new JButton("South");
        jFrame= new JFrame("Buttons");
        Container contentPane = jFrame.getContentPane();
        contentPane.add(jButton1,BorderLayout.NORTH);
        contentPane.add(jButton2,BorderLayout.CENTER);
        contentPane.add(jButton3,BorderLayout.SOUTH);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
