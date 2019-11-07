/**
 * 
 */
package org.jpractice.algorithm.sort;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-08-23 08:20:35
 * @Description: TODO
 * @version V1.0
 */
public class ShellSort extends AbstractSort {

    public void sort(Comparable[] a) {
        
        int length = a.length;
        int h = 1;
        while (h < length / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int j = h; j < a.length; j++) {
                for (int k = j; k >= h && less(a[k], a[k - h]); k -= h) {
                    exch(a, k - h, k);
                }
            }
            h = h / 3;
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    // public void sort(Comparable[] a) {
    //
    // int length = a.length;
    // int h = 1;
    // while (h < length / 3) {
    // h = 3 * h + 1;
    // }
    //
    // while (h >= 1) {
    // for (int i = h; i < length; i++) {
    // for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
    // exch(a, j - h, j);
    // }
    // }
    // h = h / 3;
    // }
    //
    // show(a);
    //
    // }

    public static void main(String[] args) {
        Integer[] arrays = { 1, 3, 6, 2, 13, 7, 9, 2, 1 };
        ShellSort shellSort = new ShellSort();
        shellSort.sort(arrays);

        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }

    }

}
