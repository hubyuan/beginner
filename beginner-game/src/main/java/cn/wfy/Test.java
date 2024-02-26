package cn.wfy;

import com.alibaba.fastjson.JSONArray;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Objects;


/**
 * @Description TODO
 * @auther wfy
 * @since 2020/10/5
 */
public class Test {
    private JFrame jFrame;
    private JButton jButton1,jButton2,jButton3;
    public static void main(String[] args) throws FileNotFoundException {

        Test test = new Test();
        System.out.println(test.isPalindrome(121));

        JSONArray jsonArray=new JSONArray();
        jsonArray.add(1);
        jsonArray.add(2);
        jsonArray.add(3);
        jsonArray.add(4);
        System.out.println(jsonArray);
        jsonArray.set(0,12);
        System.out.println(jsonArray);
    }

    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        for (int i = 0; i < (chars.length / 2); i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i - 1] = temp;
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (char aChar : chars) {
            stringBuilder.append(aChar);
        }
        String s1 = stringBuilder.toString();
        if (Objects.equals(s, s1)) {
            return true;
        }
        return false;


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
