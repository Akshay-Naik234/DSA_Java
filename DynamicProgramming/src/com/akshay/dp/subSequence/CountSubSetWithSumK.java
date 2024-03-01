package com.akshay.dp.subSequence;

public class CountSubSetWithSumK {
	public static int tabulation(int n, int k, int[] arr, int[][] dp) {
		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}
		if (arr[0] <= k) {
			dp[0][arr[0]] = 1;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				int take = 0;
				if (arr[i] <= j) {
					take = dp[i - 1][j - arr[i]];
				}
				int notTake = dp[i - 1][j];
				dp[i][j] = take + notTake;
			}
		}
		return dp[n - 1][k];
	}

	public static void main(String[] args) {
		int[] num = { 1, 4, 4, 5 };
		int tar = 5;
		int n = num.length;
		int[][] dp = new int[n][tar + 1];
		int res = tabulation(n, tar, num, dp);
		System.out.println(res);
	}
}
