package cn.wfy.打印素数;

import java.util.Scanner;

/***
 *
 * @Description Solution
 * @Author wfy
 * @Date 2021/7/1 15:06
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);

        solution.printPrime(scanner.nextInt());
    }

    private void printPrime(int num) {
        if (num == 1) {
            System.out.println();
            return;
        }

        for (int j = 2; j <= num; j++) {
            boolean flag = true;
            int sqrt = (int) Math.sqrt(j);
            for (int i = 2; i < sqrt + 1; i++) {
                if (j % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(j);
            }
        }
    }
}
