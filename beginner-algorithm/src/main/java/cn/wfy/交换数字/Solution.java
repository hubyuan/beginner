package cn.wfy.交换数字;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/4/4
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        double numbers[] = new double[]{3d, 6d};
        System.out.println(numbers[0] + " " + numbers[1]);

        solution.method(numbers, 0, 1);
        System.out.println(numbers[0] + " " + numbers[1]);
    }

    //3 6
    //4 16
    //
    private void method(double[] numbers, int a, int b) {
        numbers[a] = numbers[a] + numbers[b];

        numbers[b] = numbers[a] - 2*numbers[b];

        numbers[b] = (numbers[a] + numbers[b]) / 2;
        numbers[a] = numbers[a] - numbers[b];
//        System.out.println(numbers[a]);
//        System.out.println(numbers[b]);
    }
}
