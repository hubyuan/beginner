package cn.wfy.数独;

import java.util.LinkedList;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/4/8
 */
public class Complex {
    static int[][] arrays;
    final static int num = 9;

    public static void main(String[] args) {
        arrays = new int[][]{{0, 9, 0, 3, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 2, 9, 0, 0, 1}, {6, 0, 0, 0, 0, 0, 0, 0, 7}, {0, 7, 0, 0, 0, 0, 0, 1, 0}, {5, 0, 0, 0, 0, 0, 0, 6, 4}, {0, 0, 0, 8, 0, 4, 0, 0, 9}, {0, 1, 0, 2, 0, 0, 6, 0, 0}, {7, 8, 0, 0, 9, 0, 0, 0, 0}, {0, 0, 4, 0, 5, 0, 0, 0, 3}};
        broke(0, 0);
    }


    private static void broke(int i, int j) {
        if (i == num - 1 && j == num) {
            printArray();
            System.out.println();
            System.out.println();
            return;
        }

        if (j == num) {
            i++;
            j = 0;
        }

        if (arrays[i][j] == 0) {
            for (int k = 1; k <= num; k++) {
                boolean flag = false;

                //判断
                int volNum = j / 3;
                int rowNum = i / 3;

                for (int r2 = 0; r2 < num / 3; r2++) {
                    for (int v2 = 0; v2 < num / 3; v2++) {
                        if (arrays[rowNum * 3 + r2][volNum * 3 + v2] == k) {
                            flag = true;
                            break;
                        }
                    }
                }

                if (flag) {
                    continue;
                }
                for (int i1 = 0; i1 < num; i1++) {
                    if (arrays[i][i1] == k) {
                        flag = true;
                    }
                }
                if (flag) {
                    continue;
                }
                for (int i2 = 0; i2 < num; i2++) {
                    if (arrays[i2][j] == k) {
                        flag = true;
                    }
                }
                if (flag) {
                    continue;
                }

                arrays[i][j] = k;
                broke(i, j + 1);
                arrays[i][j] = 0;

            }
        } else {
            broke(i, j + 1);
        }
    }

    private static void printArray() {

        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays[i].length; j++) {
                System.out.print(arrays[i][j] + " ");
            }
            System.out.println();
        }
    }
}
