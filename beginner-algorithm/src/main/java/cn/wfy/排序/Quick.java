package cn.wfy.排序;

import java.util.ArrayList;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/9/14
 */
public class Quick {
    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(1);
        for (Object o : arrayList) {
            arrayList.add(2);
        }
        ArrayList<Object> arrayList1 = new ArrayList<>();

        System.arraycopy(arrayList,0,arrayList1,0,arrayList.size());

        Quick quick = new Quick();
        int i;
        int a[] = {30, 40, 60, 10, 20, 50};

        System.out.printf("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        quickSort(a, 0, a.length - 1);

        System.out.printf("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }

    public static void quickSort(int[] a, int l, int r) {

        if (l < r) {
            int i, j, x;

            i = l;
            j = r;
            x = a[i];
            while (i < j) {
                while (i < j && a[j] > x) j--; // 从右向左找第一个小于x的数
                if (i < j) a[i++] = a[j];
                while (i < j && a[i] < x) i++; // 从左向右找第一个大于x的数
                if (i < j) a[j--] = a[i];
            }
            a[i] = x;
            quickSort(a, l, i - 1); /* 递归调用 */
            quickSort(a, i + 1, r); /* 递归调用 */
        }
    }


}
