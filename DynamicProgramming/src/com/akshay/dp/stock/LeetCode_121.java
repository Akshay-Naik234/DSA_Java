package com.akshay.dp.stock;

public class LeetCode_121 {
	public static int maxProfit(int[] prices) {
		int mini = prices[0];
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			maxProfit = Math.max(maxProfit, prices[i] - mini);
			mini = Math.min(mini, prices[i]);
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(prices));
	}
}
