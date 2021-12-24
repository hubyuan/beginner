package cn.wfy.zhyhc;

import javafx.util.Pair;

import java.util.*;

/**
 * @Description 消除
 * @auther wfy
 * @since 2021/7/23
 */
public class Eliminate {

    //    int[][] arr = null;
    private final static int number = 3;
    //    HashMap<Integer, Integer> data = new HashMap<>();
    HashSet<Pair> data1 = new LinkedHashSet<>();

    //818ms
    //782ms
    //700ms
    public static void main(String[] args) {
        Eliminate eliminate = new Eliminate();
//        eliminate.show();

        eliminate.charge();

//        System.out.println("===============");
//        int[][] matrix2 = eliminate.getMatrix3();
//        eliminate.eliminated(matrix2);
////        eliminate.showData(eliminate.data);
//        eliminate.show(matrix2);
//        eliminate.eliminated(  eliminate.getMatrix2());
//        System.out.println(eliminate.data.size());
//        long a = System.currentTimeMillis();
//        eliminate.eliminated();
//        eliminate.showData();
//        long b = System.currentTimeMillis();
//        System.out.println(eliminate.data.size());
//        System.out.println(b - a + "ms");

    }

    private void charge() {
        Eliminate eliminate = new Eliminate();
        int[][] arr = eliminate.getMatrix2();
        int[][] temp = eliminate.getMatrix2();

        eliminate.show(arr);
        int count = 0;
        HashSet<Pair> tempData = new LinkedHashSet<>();
        HashSet<Pair> data1 = new LinkedHashSet<>();

        int[] real = null;
        int[][] reald = null;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int n = i; n < temp.length; n++) {
                    for (int m = j; m < temp[n].length; m++) {
                        if (i != n || j != m) {

                            int tempInt = arr[i][j];
                            arr[i][j] = temp[n][m];
                            arr[n][m] = tempInt;
                            //doing

                            eliminate.eliminated(arr, data1);
//                            System.out.println(eliminate.data.size());


                            if (data1.size() > sum) {
                                int[] real1 = {i, j, n, m};
                                real = real1;

                                int[][] reald1 = arr;
                                reald = reald1;


                                sum = data1.size();
                                tempData.clear();
                                tempData.addAll(data1);
                            } else if (data1.size() == sum) {
                                if (real != null && real.length > 3 && i + n > real[0] + real[2]) {
                                    int[] real1 = {i, j, n, m};
                                    real = real1;

                                    int[][] reald1 = arr;
                                    reald = reald1;
//                                    System.out.println("===============================");
//                                    eliminate.show(reald);
//                                    System.out.println("===============================");

                                    sum = data1.size();
                                    tempData.addAll(data1);
                                }
                            }


                            data1.clear();
                            arr = eliminate.getMatrix2();
                            temp = eliminate.getMatrix2();
                            count++;

                        }
                    }
                }
            }
        }
        System.out.println("=========================");
        System.out.println("count " + count);
        System.out.println("sum " + tempData.size());
        if (real != null) {
            for (int i = 0; i < real.length; i++) {
                System.out.print(real[i] + 1);
                System.out.print("  ");
            }
        }
        System.out.println();
        eliminate.show(reald);
//        eliminate.showData(tempData);
    }

    private void showData(HashSet<Pair> o) {
        for (Pair pair : o) {
            System.out.println(pair.getKey() + "=" + pair.getValue());
        }

    }

    public void show(int[][] o) {
        for (int[] ints : o) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }


    public void eliminated(int[][] o, HashSet<Pair> data1) {
        //判断第i，j个是否要消除
        for (int i = 0; i < o.length; i++) {
            for (int j = 0; j < o[i].length; j++) {

                //第一次消除
                eliminating(o, i, j, data1);

                //填充


            }
        }

    }

    private void eliminating(int[][] o, int i, int j, HashSet<Pair> data1) {
        row(o, i, j, data1);
        ele(o, i, j, data1);
        obli(o, i, j, data1);
    }

    private void obli(int[][] o, int i, int j, HashSet<Pair> data1) {
        //右消
        if (j < o.length - 2 && i < o.length - 2) {
            int a = o[i][j];
            int b = o[i + 1][j + 1];
            int c = o[i + 2][j + 2];
            if (a == b && b == c) {
                Pair<Integer, Integer> pair1 = new Pair<>(i, j);
                Pair<Integer, Integer> pair2 = new Pair<>(i + 1, j + 1);
                Pair<Integer, Integer> pair3 = new Pair<>(i + 2, j + 2);
                data1.add(pair1);
                data1.add(pair2);
                data1.add(pair3);
                int n = i + 3;
                int m = j + 3;
                for (int k = m; k < o[i].length; k++, n++) {
                    if (n < o.length - 2 && m < o.length - 2 && o[n][k] == c) {
                        data1.add(new Pair<>(n, k));
                    } else {
                        break;
                    }
                }
            }
        }

        //左消
        if (j > o.length - 2 && i > o.length - 2) {
            int a = o[i][j];
            int b = o[i - 1][j - 1];
            int c = o[i - 2][j - 2];

            if (a == b && b == c) {
                Pair<Integer, Integer> pair1 = new Pair<>(i, j);
                Pair<Integer, Integer> pair2 = new Pair<>(i - 1, j - 1);
                Pair<Integer, Integer> pair3 = new Pair<>(i - 2, j - 2);
                data1.add(pair1);
                data1.add(pair2);
                data1.add(pair3);
                int n = i - 3;
                int m = j - 3;
                for (int k = m; k >= 3; k--, n--) {
                    if (n > o.length - 2 && m > o.length - 2 && o[n][k] == c) {
                        data1.add(new Pair<>(n, k));
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private void ele(int[][] o, int i, int j, HashSet<Pair> data1) {
        if (j < o.length - 2) {

            int a = o[i][j];
            int b = o[i][j + 1];
            int c = o[i][j + 2];
            if (a == b && b == c) {
                Pair<Integer, Integer> pair1 = new Pair<>(i, j);
                Pair<Integer, Integer> pair2 = new Pair<>(i, j + 1);
                Pair<Integer, Integer> pair3 = new Pair<>(i, j + 2);
                data1.add(pair1);
                data1.add(pair2);
                data1.add(pair3);
                int n = j;
                for (int k = j + 3; k < o[i].length; k++) {
                    n = k;
                    if (o[i][k] == c) {
                        data1.add(new Pair<>(i, k));
                    } else {
                        break;
                    }
                }
                j = n;
            }
        }
    }

    private void row(int[][] o, int i, int j, HashSet<Pair> data1) {
        if (i < o.length - 2) {
            int a = o[i][j];
            int b = o[i + 1][j];
            int c = o[i + 2][j];
            if (a == b && b == c) {
                Pair<Integer, Integer> pair1 = new Pair<>(i, j);
                Pair<Integer, Integer> pair2 = new Pair<>(i + 1, j);
                Pair<Integer, Integer> pair3 = new Pair<>(i + 2, j);
                data1.add(pair1);
                data1.add(pair2);
                data1.add(pair3);
                int n = i;
                for (int k = i + 3; k < o.length; k++) {
                    n = k;
                    if (o[k][j] == c) {
                        data1.add(new Pair<>(k, j));
                    } else {
                        break;
                    }
                }
                i = n;
            }
        }
    }

/*
    public void getMatrix(int num) {
        if (arr == null) {
            arr = new int[num][num];
        }
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                int n = random.nextInt(3) + 1;
                arr[i][j] = n;
            }
        }

    }

    public void getMatrix1(int num) {
        if (arr == null) {
            arr = new int[num][num];
        }
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                int n = random.nextInt(3) + 1;
                arr[i][j] = n;
            }
        }

    }*/

    public int[][] getMatrix2() {
        int[][] arr1 = {{3, 1, 2, 1, 2}, {1, 3, 3, 2, 1}, {2, 3, 1, 3, 1}, {1, 1, 2, 2, 3}, {1, 3, 3, 2, 1}};
//        int[][] arr1 = {{3, 1, 2}, {1, 3, 3}, {2, 3, 1}};
        int[][] arr2 = {{1, 3, 2}, {1, 3, 3}, {2, 3, 1}};

        return arr1;


    }

    public int[][] getMatrix3() {
        int[][] arr1 = {{3, 1, 2, 1, 2}, {1, 3, 3, 2, 1}, {2, 3, 1, 3, 1}, {1, 3, 2, 2, 1}, {1, 3, 3, 2, 1}};
//        int[][] arr1 = {{3, 1, 2}, {1, 3, 3}, {2, 3, 1}};
        int[][] arr2 = {{1, 3, 2}, {1, 3, 3}, {2, 3, 1}};

        return arr1;


    }


    public void xiaochu(int[] step,int[][] array){
        int x=0;
        int y=0;
        if (x!=0){
            for (int i = 0; i < array[x].length; i++) {
//                array[x]
//                array[i][y]
            }
        }
    }
}
