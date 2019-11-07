/**
 * 
 */
package org.jpractice.algorithm;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-10-18 05:13:00
 * @Description: TODO
 * @version V1.0
 */
public class Leetcode121 {

    public int maxProfit(int[] prices) {

        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > 0 && profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    public int maxProfit2(int[] prices) {

        int minPrice = Integer.MAX_VALUE;

        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Leetcode121 leetcode121 = new Leetcode121();
        System.out.println(leetcode121.maxProfit2(new int[] { 7, 6, 4, 3, 1 }));
    }

}
