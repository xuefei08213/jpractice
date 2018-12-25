package org.jpractice.algorithm;

import org.junit.Test;

public class LeetCode88Test {

    @Test
    public void test() {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 5, 6 };
        LeetCode88 code88 = new LeetCode88();
        code88.merge(nums1, 3, nums2, 3);
        code88.merge2(nums1, 3, nums2, 3);
    }

}
