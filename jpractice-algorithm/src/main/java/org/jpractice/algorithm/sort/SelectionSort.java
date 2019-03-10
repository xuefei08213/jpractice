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
public class SelectionSort extends AbstractSort {
    
    public static void sort(Comparable[] a) {
        int length = a.length;
        int min = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
                System.out.println(min);
                exch(a, min, i);
            }
        }
        show(a);
    }

    public static void main(String[] args) {
        Integer[] numbsers = new Integer[] { 5, 3, 7, 11, 22, 4, 3 };
        sort(numbsers);
    }

}
