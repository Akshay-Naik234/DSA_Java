package com.akshay.dp.stock;

public class LeetCode_188 {
	public static int tabulation(int[] prices,int k) {
		int n = prices.length;
		int[][][] dp = new int[n + 1][2][k+1];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < 2; j++) {
				for (int cap = 1; cap <= k; cap++) {
					if (j == 0) {
						dp[i][j][cap] = Math.max(0 + dp[i + 1][0][cap], -prices[i] + dp[i + 1][1][cap]);
					} else {
						dp[i][j][cap] = Math.max(0 + dp[i + 1][1][cap], prices[i] + dp[i + 1][0][cap - 1]);
					}
				}
			}
		}
		return dp[0][0][k];
	}

	public static void main(String[] args) {
		int[] prices = { 3,2,6,5,0,3 };
		int k =2;
		int res = tabulation(prices,k);
		System.out.println(res);
	}
}
