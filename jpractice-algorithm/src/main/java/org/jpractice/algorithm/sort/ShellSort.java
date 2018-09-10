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
public class ShellSort {

    private void sort(int[] arrays) {

        for (int gap = arrays.length / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < arrays.length; i++) {

                int j = i;

                System.out.println(j);

                while (j - gap >= 0 && arrays[j] < arrays[j - gap]) {
                    int tmp = arrays[j];
                    arrays[j] = arrays[j - gap];
                    arrays[j - gap] = tmp;
                    j -= gap;
                    System.out.println("====" + j);

                    // for (int m = 0; m < 1内部 arrays.length; m++) {
                    // System.out.print(arrays[m]);
                    // }
                    // System.out.println();
                }
            }
        }

        for (int m = 0; m < arrays.length; m++) {
            System.out.println(arrays[m]);
        }
    }

    public static void main(String[] args) {
        int[] arrays = { 1, 3, 6, 2, 13, 7, 9, 2, 1 };
        ShellSort shellSort = new ShellSort();
        shellSort.sort(arrays);

    }

}
