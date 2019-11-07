/**
 * 
 */
package org.jpractice.algorithm.priorityqueue;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-02-15 09:10:14
 * @Description: TODO
 * @version V1.0
 */
public class HeapSort {

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();

        Integer[] a = { 1, 4, 2, 66, 22, 45 };
        heapSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public void sort(Comparable[] a) {

        int n = a.length;
        // 将给定数组转换为堆
        for (int k = n / 2; k >= 1; k--) {
            sink(a, k, n);
        }

        // 将堆中最大的元素删除，然后放入堆缩小后数组空出来的位置
        while (n > 1) {
            exch(a, 1, n);
            sink(a, 1, --n);
        }
    }

    private void sink(Comparable[] pq, int k, int n) {

        while (2 * k < n) {
            int j = 2*k;
            if (less(pq, j, j + 1)) {
                j++;
            }
            if (!less(pq, k, j)) {
                break;
            }
            exch(pq, k, j);
            k = j;
        }
    }

    private static boolean less(Comparable[] a, int i, int m) {
        return a[i - 1].compareTo(a[m - 1]) < 0;
    }

    private static void exch(Object[] a, int i, int m) {
        Object swap = a[i - 1];
        a[i - 1] = a[m - 1];
        a[m - 1] = swap;
    }
}
