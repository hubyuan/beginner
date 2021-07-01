package cn.wfy.计算纸张的折叠次数;

import java.util.Scanner;

/***
 *
 * @Description Solution
 * @Author wfy
 * @Date 2021/7/1 15:28
 */
public class Solution {
    public static void main(String[] args) {
        int a = 2 * 2;


        Scanner scanner = new Scanner(System.in);
        double height = scanner.nextDouble();
        double paperThickness = scanner.nextDouble();
        int number = 0;
        for (; ; ) {
            if (paperThickness >= height) {
                break;
            }
            paperThickness *= 2;
            number++;
        }
        System.out.println("Need to fold " + number + " times");
    }
}
