package com.akshay.dp.subSequence;

public class Patition2SubsetWithMinAbsoluteSum {
	public static int tabulation(int n, int[] arr) {
		int totalSum = 0;
		for (int i = 0; i < n; i++) {
			totalSum += arr[i];
		}
		int k = totalSum;
		boolean[][] dp = new boolean[n][k + 1];
		for (int i = 0; i < n; i++) {
			dp[i][0] = true;
		}
		if (arr[0] <= k) {
			dp[0][arr[0]] = true;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				boolean take = false;
				if (arr[i] <= j) {
					take = dp[i - 1][j - arr[i]];
				}
				boolean notTake = dp[i - 1][j];
				dp[i][j] = take | notTake;
			}
		}
		int mini = Integer.MAX_VALUE;
		for (int i = 0; i < totalSum; i++) {
			if (dp[n - 1][i]) {
				int diff = Math.abs(i - (totalSum - i));
				mini = Math.min(mini, diff);
			}
		}
		return mini;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 1, 5, 2, 8 };
		int res = tabulation(nums.length, nums);
		System.out.println(res);
	}
}
