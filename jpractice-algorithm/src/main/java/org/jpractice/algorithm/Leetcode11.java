/**
 * 
 */
package org.jpractice.algorithm;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2020-02-05 10:51:28
 * @Description: TODO
 * @version V1.0
 */
public class Leetcode11 {

    public int maxArea(int[] height) {

        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = 0;
                if (height[j] <= height[i]) {
                    area = height[j] * (j - i);
                } else {
                    area = height[i] * (j - i);
                }
                if (area > max) {
                    max = area;
                }
            }
        }

        return max;
    }

    public int maxAreaByTwoPointer(int[] height) {

        int max = 0, l = 0, r = height.length - 1;
        while (l < r) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        int[] heights = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        Leetcode11 leetcode11 = new Leetcode11();
        System.out.println(leetcode11.maxArea(heights));
        System.out.println(leetcode11.maxAreaByTwoPointer(heights));

    }

}
