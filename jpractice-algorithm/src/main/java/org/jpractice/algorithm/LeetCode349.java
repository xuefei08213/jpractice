/**
 * 
 */
package org.jpractice.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-08-14 12:35:23
 * @Description: Given two arrays,write a function to compute their intersection
 * @version V1.0
 */
public class LeetCode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Arrays.sort(nums1);
        // Arrays.sort(nums2);

        List<Integer> integers = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    if (!integers.contains(nums1[i])) {
                        integers.add(nums1[i]);
                    }
                }
            }
        }

        int[] result = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            result[i] = integers.get(i);
        }

        return result;

    }

    public static void main(String[] args) {
        LeetCode349 code349 = new LeetCode349();
        int[] nums1 = { 4, 9, 5 };
        int[] nums2 = { 9, 4, 9, 8, 4 };
        int[] result = code349.intersection(nums1, nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
