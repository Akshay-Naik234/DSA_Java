package com.akshay.dp.subSequence;

public class LeetCode_416 {
	public static boolean tabulation(int n, int k, int[] arr, boolean[][] dp) {
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
		return dp[n - 1][k];
	}

	public static boolean canPartition(int[] nums) {
		int totalSum = 0;
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			totalSum += nums[i];
		}
		if (totalSum % 2 == 1) {
			return false;
		}
		int s = totalSum / 2;
		boolean[][] dp = new boolean[n][s + 1];
		return tabulation(n, s, nums, dp);
	}

	public static void main(String[] args) {
		int[] nums = { 1, 5, 11, 5 };
		boolean res = canPartition(nums);
		System.out.println(res);
	}
}
