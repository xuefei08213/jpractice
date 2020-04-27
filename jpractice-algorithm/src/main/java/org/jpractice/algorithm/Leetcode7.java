/**
 * 
 */
package org.jpractice.algorithm;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2020-02-08 09:42:47
 * @Description: TODO
 * @version V1.0
 */
public class Leetcode7 {

    public int reverse(int x) {

        int result = 0;
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;

            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;

    }

    public static void main(String[] args) {
        Leetcode7 leetcode7 = new Leetcode7();
        System.out.println(leetcode7.reverse(123));
        System.out.println(leetcode7.reverse(-123));
        System.out.println(leetcode7.reverse(120));
    }

}
