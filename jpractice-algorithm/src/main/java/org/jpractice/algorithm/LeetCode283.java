/**
 * 
 */
package org.jpractice.algorithm;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-06-25 23:02:00
 * @Description: Given an array nums, write a function to move all 0's to the
 *               end of it while maintaining the relative order of the non-zero
 *               elements.
 *               Example:
 *                  Input: [0,1,0,3,12]
 *                  Output: [1,3,12,0,0]
 *               Note:
 *                  You must do this in-place without making a copy of the array.
 *                  Minimize the total number of operations.
 * @version V1.0
 */
public class LeetCode283 {

    public void moveZeroes_solution_one(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] == 0) {
                        nums[j] = nums[i];
                        nums[i] = 0;
                    }
                }
            }
        }
    }

    public void moveZeroes_solution_two(int[] nums) {

        int lastNonZeroFoundAt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }

        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    public static void main(String[] args) {
        LeetCode283 code283 = new LeetCode283();
        int[] nums = { 0, 0, 1, 0, 3, 12, 0 };
        // code283.moveZeroes_solution_one(nums);
        code283.moveZeroes_solution_two(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }

}
