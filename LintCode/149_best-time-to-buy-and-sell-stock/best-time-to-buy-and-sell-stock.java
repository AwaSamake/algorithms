/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock
@Language: Java
@Datetime: 17-06-05 21:39
*/

public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        int bestProfit = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; ++i) {
            profit += prices[i] - prices[i - 1];
            if (profit < 0) {
                profit = 0;
            }
            bestProfit = Math.max(bestProfit, profit);
        }
        return bestProfit;
    }
}