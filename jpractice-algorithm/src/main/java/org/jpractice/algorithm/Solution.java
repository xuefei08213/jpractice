/**
 * 
 */
package org.jpractice.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-06-23 18:31:13
 * @Description: Given an array of integers, return indices of the two numbers
 *               such that they add up to a specific target.
 * 
 *               You may assume that each input would have exactly one solution,
 *               and you may not use the same element twice.
 * 
 *               Given nums = [2, 7, 11, 15], target = 9,
 * 
 *               Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * @version V1.0
 */
public class Solution {
	public int[] twoSum(int[] nums, int target) {

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");

	}

	public int[] twoSum2(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { i, map.get(complement) };
			}
		}

		throw new IllegalArgumentException("No two sum solution");

	}

	public int[] twoSum3(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { map.get(complement), i };
			} else {
				map.put(nums[i], i);
			}
		}

		throw new IllegalArgumentException("No two sum solution");

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = { 1, 3, 2, 4 };
		solution.twoSum2(nums, 6);
	}
}
