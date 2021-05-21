package cn.wfy.divisibleByThree;

/***
 *
 * @Description Solution
 * @Author wfy
 * @Date 2021/5/19 17:44
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1, 2, 3, 423, 43, 112, 22};
        System.out.println(solution.doing1(array));
    }

    private int doing1(int[] array) {
        int temp = -1;
        for (int i = 0; i < array.length; i++) {
            int a = 0;
            int b = 1;
            while (b != 0) {
                b = array[i] >> 1;
                a += b;
            }

            if (a % 3 == 0) {
                if (a > temp) {
                    temp = a;
                }
            }
        }
        return temp;
    }

    private int doing(int[] array) {

        int temp = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 2 && array[i] % 3 == 0) {
                if (array[i] > temp) {
                    temp = array[i];
                }
            }
        }
        return temp;
    }
}
