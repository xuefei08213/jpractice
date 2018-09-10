/**
 * 
 */
package org.jpractice.algorithm;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-08-30 19:09:16
 * @Description: TODO
 * @version V1.0
 */
public class LeetCode53 {

    public static int maxSubArray(int[] A) {
        int maxSoFar = A[0], maxEndingHere = A[0];
        for (int i = 1; i < A.length; ++i) {
            maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arrays = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        maxSubArray(arrays);
    }


}
