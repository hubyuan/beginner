package cn.wfy.股票买卖1;

/***
 *
 * @Description Solution
 * @Author wfy
 * @Date 2021/7/2 17:02
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arrays = {7, 1, 5, 3, 6, 4};
        int k = 2;
        int handler = solution.solution(arrays);
        System.out.println(handler);
    }

    private int solution(int[] arrays, int k) {

        return 0;
    }


    private int solution(int[] arrays) {
        int res = 0;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = i; j < arrays.length; j++) {
                int temp;
                if ((j - i) > 0) {
                    temp = j - i;
                    if (temp > res) {
                        res = temp;
                    }
                }
            }
        }
        return res;
    }
}
