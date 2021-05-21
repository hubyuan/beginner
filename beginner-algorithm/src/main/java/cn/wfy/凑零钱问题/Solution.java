package cn.wfy.凑零钱问题;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/4/4
 */
public class Solution {
    static int amount = 8169;
    static int[] array = new int[amount + 1];

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = new int[]{1, 2, 5, 10, 20, 50, 100};
        long a = System.currentTimeMillis();
        System.out.println(solution.methodOfViolence2(coins, amount) + " time");
        long b = System.currentTimeMillis();
        System.out.println(b - a + " ms");
        System.out.println("count: " + count);

    }


    // coins 中是可选硬币面值，amount 是目标金额
    private int methodOfViolence(int[] coins, int amount) {
        count++;
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int methodValue = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int value = methodOfViolence(coins, amount - coins[i]);

            if (value == -1) {
                continue;
            }
            methodValue = Math.min(methodValue, value + 1);
        }
        return methodValue == Integer.MAX_VALUE ? -1 : methodValue;
    }

    static long count = 0;

    private int methodOfViolence1(int[] coins, int amount) {
        count++;

        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (array[amount] > 0) {
            return array[amount];
        }
        int methodValue = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int value;
            value = methodOfViolence1(coins, amount - coins[i]);
            if (value == -1) {
                continue;
            }
            methodValue = Math.min(methodValue, value + 1);
            array[amount] = methodValue;
        }


        return methodValue == Integer.MAX_VALUE ? -1 : methodValue;

    }

    private int methodOfViolence2(int[] coins, int amount) {
        count++;
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int value = Integer.MAX_VALUE;
        int temp;
        int sum = amount;
        for (int j = 0; j < coins.length; j++) {
            temp = amount - coins[j];
            if (temp < 0) {
                continue;
            }
            sum = Math.min(sum, temp);

        }

        int valueTemp = methodOfViolence2(coins, sum);
        if (valueTemp < 0) {
            return -1;
        }
        value = Math.min(value, valueTemp + 1);

        return value == Integer.MAX_VALUE ? -1 : value;

    }
}
