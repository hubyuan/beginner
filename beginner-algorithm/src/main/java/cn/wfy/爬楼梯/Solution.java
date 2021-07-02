package cn.wfy.爬楼梯;

/***
 *
 * @Description Solution
 * @Author wfy
 * @Date 2021/7/2 17:45
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = solution.solution(10);
        System.out.println(num);
    }

    private int solution(int sum) {
        int number = 0;
        return aaaa1(sum--, number++);
    }

    private int aaaa1(int sum, int number) {
        if (sum == 0) {
            return number;
        }
        return aaaa1(sum--, number++);
    }


}
