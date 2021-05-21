package cn.wfy.数独;

import java.util.LinkedList;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/4/8
 */
public class Simple {
    static int[][] arrays;
    final static int num = 3;

    public static void main(String[] args) {
        arrays = new int[][]{{3, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        broke(0, 0);
    }

    private static void broke(int i, int j) {
        System.out.println(i + "=" + j);
        if (i == num) {
            printArray();
            return;
        }

        if (arrays[i][j] == 0) {
            for (int k = 1; k <= num; k++) {
                if (i==num){
                    break;
                }

                //判断
                LinkedList<Integer> linkedList = new LinkedList<>();
                LinkedList<Integer> linkedList1 = new LinkedList<>();
                for (int i1 = 0; i1 < num; i1++) {
                    linkedList.add(arrays[i][i1]);
                }
                for (int i2 = 0; i2 < num; i2++) {
                    linkedList.add(arrays[i2][j]);
                }
                if (linkedList.contains(k)) {
                    continue;
                }
                if (linkedList1.contains(k)) {
                    continue;
                }

                arrays[i][j] = k;
                if (i <= num - 1 && j < num - 1) {
                    j++;
                } else if (i <= num - 1 && j == num - 1) {
                    j = 0;
                    i++;
                }
                broke(i, j);

            }
        } else {
            if (i <= num - 1 && j < num - 1) {
                j++;
            } else if (i <= num - 1 && j == num - 1) {
                j = 0;
                i++;
            }
            broke(i, j);
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
