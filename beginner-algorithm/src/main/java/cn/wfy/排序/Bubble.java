package cn.wfy.排序;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/9/14
 */
public class Bubble {
    public static void main(String[] args) {
        Bubble bubble = new Bubble();
        int[] array = {2, 56, 6, 21, 3, 44,};
        int[] soulution = bubble.soulution(array);
        for (int i = 0; i < soulution.length; i++) {
            System.out.println(soulution[i]);
        }

    }

    private int[] soulution(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        return array;
    }
}
