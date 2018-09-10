/**
 * 
 */
package org.jpractice.algorithm.sort;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-08-16 17:32:43
 * @Description: TODO
 * @version V1.0
 */
public class InsertionSort {

    /**
     * 比较了1次 9-11-8-7-3-9-2- 比较了1次 比较了2次 8-9-11-7-3-9-2- 比较了1次 比较了2次 比较了3次
     * 7-8-9-11-3-9-2- 比较了1次 比较了2次 比较了3次 比较了4次 3-7-8-9-11-9-2- 比较了1次 3-7-8-9-9-11-2-
     * 比较了1次 比较了2次 比较了3次 比较了4次 比较了5次 比较了6次 2-3-7-8-9-9-11-
     * 
     * @param arrays
     */
    public static void sort(int[] arrays) {

        int length = arrays.length;
        for (int i = 1; i < length; i++) {
            int count = 0;
            for (int j = i; j > 0 && arrays[j] < arrays[j - 1]; j--) {
                System.out.println(String.format("比较了%s次", ++count));
                    int key = arrays[j];
                    arrays[j] = arrays[j - 1];
                    arrays[j - 1] = key;
                for (int m = 0; m < arrays.length; m++) {
                    System.out.print(arrays[m] + "-");
                }
                System.out.println("");
            }
            for (int m = 0; m < arrays.length; m++) {
                System.out.print(arrays[m] + "-");
            }
            System.out.println("");
        }
    }

    /**
     * 
     * 比较次数为：1 9-11-8-7-3-9-2- 比较次数为：1 比较次数为：2 8-9-11-7-3-9-2- 比较次数为：1 比较次数为：2
     * 比较次数为：3 7-8-9-11-3-9-2- 比较次数为：1 比较次数为：2 比较次数为：3 比较次数为：4 3-7-8-9-11-9-2-
     * 比较次数为：1 3-7-8-9-9-11-2- 比较次数为：1 比较次数为：2 比较次数为：3 比较次数为：4 比较次数为：5 比较次数为：6
     * 2-3-7-8-9-9-11-
     * 
     */

    public static void main(String[] args) {
        int[] aa = { 11, 9, 8, 7, 3, 9, 2 };
        sort(aa);
    }

}
