package cn.wfy.数字找规律;

/***
 *
 * @Description Solution
 * @Author wfy
 * @Date 2021/5/13 12:14
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 5, 13 , 20};
        Integer calc = new SimpleRule().calc(array);
        System.out.println(calc);

    }

}
