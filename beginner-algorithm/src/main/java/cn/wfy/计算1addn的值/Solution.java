package cn.wfy.计算1addn的值;

/***
 *
 * @Description Solution
 * @Author wfy
 * @Date 2021/7/1 16:05
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.add(4));
        solution.getIndexOne("asdfsd");
    }

    public int add(int number) {
        int i;
        int sum = 0;
        // write your code here
        if (number < 1) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        if (number % 2 == 0) {
            sum = (number * number + number) / 2;
        } else {
            sum = (number + 1) * (number / 2) + (number + 1) / 2;
        }
        return sum;
    }




    public char getIndexOne(String str) {
        // write your code here
        char[] chars = str.toCharArray();
        char aChar = chars[1];
        System.out.println(aChar);
        return aChar;
    }



}
