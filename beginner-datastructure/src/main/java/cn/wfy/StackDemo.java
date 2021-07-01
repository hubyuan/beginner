package cn.wfy;

import java.util.*;

/***
 *
 * @Description StackDemo
 * @Author wfy
 * @Date 2021/6/29 17:43
 */
public class StackDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        HashMap<Object, Object> map = new HashMap<>(2, 1.1f);
        for (int i = 0; i < 100; i++) {

            map.put(i,i);
        }
        System.out.println(map);


    }
}
