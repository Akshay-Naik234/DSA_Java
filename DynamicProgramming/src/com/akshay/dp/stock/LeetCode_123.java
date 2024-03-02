package com.akshay.dp.stock;

public class LeetCode_123 {
	public static int tabulation(int[] prices) {
		int n = prices.length;
		int[][][] dp = new int[n + 1][2][3];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < 2; j++) {
				for (int cap = 1; cap <= 2; cap++) {
					if (j == 0) {
						dp[i][j][cap] = Math.max(0 + dp[i + 1][0][cap], -prices[i] + dp[i + 1][1][cap]);
					} else {
						dp[i][j][cap] = Math.max(0 + dp[i + 1][1][cap], prices[i] + dp[i + 1][0][cap-1]);
					}
				}
			}
		}
		return dp[0][0][2];
	}

	public static void main(String[] args) {
		int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
		int res = tabulation(prices);
		System.out.println(res);
	}
}
