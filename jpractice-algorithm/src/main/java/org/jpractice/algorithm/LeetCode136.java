/**
 * 
 */
package org.jpractice.algorithm;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-07-14 00:40:49
 * @Description: TODO
 * @version V1.0
 */
public class LeetCode136 {

    public int solutionWithMap(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.remove(num);
            } else {
                map.put(num, num);
            }
        }

        return map.values().iterator().next();

    }

    public int solutionXOR(int[] nums) {

        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    @Test
    public void test() {
        LeetCode136 leetCode136 = new LeetCode136();
        int[] nums = { 2, 2, 1 };
        assertEquals(1, leetCode136.solutionWithMap(nums));
        assertEquals(1, leetCode136.solutionXOR(nums));

        int[] nums2 = { 4, 1, 2, 1, 2 };
        assertEquals(4, leetCode136.solutionWithMap(nums2));
        assertEquals(4, leetCode136.solutionXOR(nums2));
    }

}
