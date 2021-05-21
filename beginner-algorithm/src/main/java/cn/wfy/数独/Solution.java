package cn.wfy.数独;

import java.util.LinkedList;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/4/7
 */
public class Solution {
    static Integer[][] sudokuArray;

    public static void main(String[] args) {
        Integer[] voloum1 = new Integer[]{6, 9, 2, null, 8, 3, null, null, 1};
        Integer[] voloum2 = new Integer[]{null, 5, null, 1, null, 2, 3, 8, null};
        Integer[] voloum3 = new Integer[]{null, 8, null, 4, 9, 7, null, null, null};
        Integer[] voloum4 = new Integer[]{null, null, 4, 2, 7, null, null, 3, 5};
        Integer[] voloum5 = new Integer[]{null, 2, 6, null, null, null, 1, null, null};
        Integer[] voloum6 = new Integer[]{null, 7, 3, null, null, 1, 8, null, null};
        Integer[] voloum7 = new Integer[]{7, null, null, 9, 1, null, null, 6, 2};
        Integer[] voloum8 = new Integer[]{null, null, null, 7, 3, 4, null, null, 8};
        Integer[] voloum9 = new Integer[]{null, null, 5, null, 2, null, 9, 7, null};
        Integer[][] sudokuArray = new Integer[][]{voloum1, voloum2, voloum3, voloum4, voloum5, voloum6, voloum7, voloum8, voloum9};

        broke(0, 0);
    }

    private static void broke(int i, int j) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        if (linkedList.size() == 9) {
            return;
        }
        for (int k = 1; k < 10; k++) {
            if (sudokuArray[i][j] != null) {
                linkedList.add(sudokuArray[i][j]);
                if (i >= 9) {
                    broke(i, j + 1);
                } else {
                    broke(i + 1, j);
                }
                linkedList.removeLast();
            }
        }

    }
}
