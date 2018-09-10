/**
 * 
 */
package org.jpractice.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-07-12 06:59:28
 * @Description: TODO
 * @version V1.0
 */
public class SearchInsertPosition {

    /**
     * Given a sorted array and a target value, return the index if the target is
     * found. If not, return the index where it would be if it were inserted in
     * order. You may assume no duplicates in the array.
     * 
     * Input: [1,3,5,6], 5 Output: 2
     * 
     * Input: [1,3,5,6], 2 Output: 1
     * 
     * Input: [1,3,5,6], 7 Output: 4
     * 
     * Input: [1,3,5,6], 0 Output: 0
     * 
     * 定义hasOne变量用来标识是否找到一个第一个比target大的值，找到之后用map保存值跟索引的映射，并将hasOne设置为true
     * 遍历nums数组，找到第一个比target大值，并判断数组中是否有跟target相等的值，如果找到相等的值就直接返回
     * 在循环结束之后，判断map中是否有值，如果有值则取出对应的index，如果没有值，则说明target比数组中的所有的值都要大，它的索引应该是nums数组的长度
     */

    public int searchInsert(int[] nums, int target) {

        int result = 0;
        boolean hasOne = false;
        int firstKey = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > target && !hasOne) {
                firstKey = num;
                map.put(firstKey, i);
                hasOne = true;
            }

            if (num == target) {
                result = i;
                return result;
            }
        }
        
        if(map.isEmpty()) {
            result = nums.length;
        }else {
            result = map.get(firstKey);
        }
        return result;
    }

    /**
     * 采用二分查找
     * 
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int[] nums, int target) {

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }


    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int[] nums = new int[] { 1, 3, 5, 6 };
        System.out.println(searchInsertPosition.searchInsert(nums, 5));
        System.out.println(searchInsertPosition.searchInsert(nums, 2));
        System.out.println(searchInsertPosition.searchInsert(nums, 7));
        System.out.println(searchInsertPosition.searchInsert(nums, 0));
    }
}
