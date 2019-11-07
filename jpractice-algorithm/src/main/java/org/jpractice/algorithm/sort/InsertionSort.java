/**
 * 
 */
package org.jpractice.algorithm.sort;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-08-16 17:32:43
 * @Description: 插入排序
 * @version V1.0
 */
public class InsertionSort extends AbstractSort{
    
    public static void sort(Comparable[] a) {

        for (int i = 0; i < a.length - 1; i++) {
            int j = i + 1;
            while (j > 0 && a[j].compareTo(a[j - 1]) < 0) {
                Comparable tmp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = tmp;
                j--;
            }
        }
    }
    


    // public static void sort(Comparable[] a) {
    // int length = a.length;
    // for (int i = 0; i < length - 1; i++) {
    // for (int j = i + 1; j >= 1; j--) {
    // if (less(a[j], a[j - 1])) {
    // exch(a, j, j - 1);
    // }
    // }
    // }
    //
    // show(a);
    // }

    public static void main(String[] args) {
        Integer[] aa = { 11, 9, 8, 7, 3, 9, 2 };
        sort(aa);
        for (int i = 0; i < aa.length; i++) {
            System.out.println(aa[i]);
        }
    }

}
