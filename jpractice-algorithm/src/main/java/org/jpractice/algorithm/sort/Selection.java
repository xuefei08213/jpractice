/**
 * 
 */
package org.jpractice.algorithm.sort;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-08-14 07:37:38
 * @Description: TODO
 * @version V1.0
 */
public class Selection {

    public void sort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }

        for (int m = 0; m < nums.length; m++) {
            System.out.print(nums[m] + " ");
        }
    }

    public static void main(String[] args) {

        int[] nums = { 4, 2, 99, 22, 4, 55 };

        Selection selection = new Selection();
        selection.sort(nums);
    }
}
