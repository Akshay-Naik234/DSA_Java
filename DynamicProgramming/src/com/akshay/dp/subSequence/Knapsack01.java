package com.akshay.dp.subSequence;

public class Knapsack01 {
	public static int f(int[] weight, int[] value, int n, int maxWeight, int[][] dp) {
		if (n == 0) {
			if (weight[0] <= maxWeight) {
				return value[0];
			} else {
				return 0;
			}
		}
		if (dp[n][maxWeight] != -1) {
			return dp[n][maxWeight];
		}
		int take = Integer.MIN_VALUE;
		if (weight[n] <= maxWeight) {
			take = value[n] + f(weight, value, n - 1, maxWeight - weight[n], dp);
		}
		int notTake = f(weight, value, n - 1, maxWeight, dp);
		return dp[n][maxWeight] = Math.max(take, notTake);
	}

	public static int tabulation(int[] weight, int[] value, int n, int maxWeight, int[][] dp) {
		for (int i = weight[0]; i <= maxWeight; i++) {
			dp[0][i] = value[0];
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= maxWeight; j++) {
				int take = Integer.MIN_VALUE;
				if (weight[i] <= j) {
					take = value[i] + dp[i - 1][j - weight[i]];
				}
				int notTake = dp[i - 1][j];
				dp[i][j] = Math.max(take, notTake);
			}
		}
		return dp[n - 1][maxWeight];
	}

	static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
		int[][] dp = new int[n][maxWeight + 1];
//		for (int[] is : dp) {
//			Arrays.fill(is, -1);
//		}
		return tabulation(weight, value, n, maxWeight, dp);
	}

	public static void main(String[] args) {
		int[] weight = { 1, 2, 4, 5 };
		int[] value = { 5, 4, 8, 6 };
		int maxWeight = 5;
		int n = 4;
		int res = knapsack(weight, value, n, maxWeight);
		System.out.println(res);
	}
}
