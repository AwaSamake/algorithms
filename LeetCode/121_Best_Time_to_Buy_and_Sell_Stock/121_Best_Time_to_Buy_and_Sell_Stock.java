/**
 *
 * 121. Best Time to Buy and Sell Stock
 *     Say you have an array for which the ith element is the price of a given stock on
 *     day i.
 *     If you were only permitted to complete at most one transaction (ie, buy one and
 *     sell one share of the stock), design an algorithm to find the maximum profit.
 *     Example 1:
 *         Input: [7, 1, 5, 3, 6, 4]
 *         Output: 5
 *         max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger
 *         than buying price)
 *     Example 2:
 *         Input: [7, 6, 4, 3, 1]
 *         Output: 0
 *         In this case, no transaction is done, i.e. max profit = 0.
 *
 */
import java.util.*;

public class Solution {
	public int maxProfit(int[] prices) {
		for (int i = prices.length - 1; i > 0; --i) {
			prices[i] -= prices[i - 1];
		}

		int profit = 0, max = 0;
		for (int i = 1; i < prices.length; ++i) {
			profit += prices[i];
			if (profit < 0) {
				profit = 0;
			}
			max = Math.max(profit, max);
		}
		return max;
	}
}