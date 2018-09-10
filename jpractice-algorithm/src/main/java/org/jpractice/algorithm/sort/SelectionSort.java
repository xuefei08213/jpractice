/**
 * 
 */
package org.jpractice.algorithm.sort;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-08-14 06:47:16
 * @Description: 选择排序算法
 * @version V1.0
 */
public class SelectionSort {

    public static void main(String[] args) {
        Integer[] numbsers = new Integer[] { 5, 3, 7, 11, 22, 4, 3 };
        sort(numbsers);
    }

    public static void sort(Comparable[] a) {

        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
                exch(a, i, min);
            }
        }
        show(a);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
