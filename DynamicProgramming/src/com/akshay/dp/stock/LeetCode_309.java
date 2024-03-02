package com.akshay.dp.stock;

public class LeetCode_309 {
	public static int tabulation(int[] prices) {
		int n = prices.length;
		int[][] dp = new int[n + 2][2];

		int profit = 0;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < 2; j++) {
				if (j == 0) {
					profit = Math.max(0 + dp[i + 1][0], -prices[i] + dp[i + 1][1]);
				} else {
					profit = Math.max(0 + dp[i + 1][1], prices[i] + dp[i + 2][0]);
				}
				dp[i][j] = profit;
			}
		}
		return dp[0][0];
	}

	public static int maxProfit(int[] prices) {
		return tabulation(prices);
	}
	
	public static void main(String[] args) {
		int[] prices = {1,2,3,0,2};
		System.out.println(maxProfit(prices));
	}
}
