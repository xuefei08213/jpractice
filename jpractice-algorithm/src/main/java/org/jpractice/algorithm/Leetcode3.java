/**
 * 
 */
package org.jpractice.algorithm;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2020-04-26 07:07:40
 * @Description: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * @version V1.0
 */
public class Leetcode3 {

    /**
     * 蛮力解法
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        String resultStr = "";
        int strLength = s.length();
        
        for (int i = 0; i < strLength; i++) {
            String initialStr = s.substring(i, i + 1);
            for (int j = i + 1; j < strLength; j++) {
                if (initialStr.indexOf(s.substring(j, j + 1)) < 0) {
                    initialStr = initialStr + s.substring(j, j + 1);
                    if (initialStr.length() > resultStr.length()) {
                        resultStr = initialStr;
                    }
                } else {
                    break;
                }
            }
            if (initialStr.length() > resultStr.length()) {
                resultStr = initialStr;
            }
        }
        return resultStr.length();
    }

    public static void main(String[] args) {
        Leetcode3 leetcode3 = new Leetcode3();
        leetcode3.lengthOfLongestSubstring("pwwkew");
    }
}
