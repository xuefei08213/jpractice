package org.jpractice.algorithm;
/**
 * 
 */

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-09-04 14:09:28
 * @Description: TODO
 * @version V1.0
 */
public class LeetCode70 {

    public int climbStairs(int n) {
        int result = 0;
        if (1 == n) {
            return 1;
        }
        if (2 == n) {
            return 2;
        }
        result = climbStairs(n - 1) + climbStairs(n - 2);
        return result;
    }

    /**
     * Brute Force
     * 
     * @param n
     * @return
     */
    public int climb_Stairs(int n) {
        return climb_Stairs(0, n);
    }

    public int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }


    public static void main(String[] args) {
        LeetCode70 code70 = new LeetCode70();
        System.out.println(code70.climbStairs(40));
        System.out.println(code70.climb_Stairs(40));
        ;
    }

}
