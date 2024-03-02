package com.akshay.dp.LIS;

import java.util.Arrays;

public class LeetCode_300 {
	public static int f(int[] nums, int n, int ind, int[][] dp, int prev_index) {
		if (ind == n) {
			return 0;
		}
		if (dp[ind][prev_index + 1] != -1) {
			return dp[ind][prev_index + 1];
		}
		int take = 0;
		if (prev_index == -1 || nums[prev_index] < nums[ind]) {
			take = 1 + f(nums, n, ind + 1, dp, ind);
		}
		int notTake = 0 + f(nums, n, ind + 1, dp, prev_index);
		return dp[ind][prev_index + 1] = Math.max(take, notTake);
	}

	public static int tabulation(int[] nums) {
		int n = nums.length;
		int[][] dp = new int[n + 1][n + 1];
		for (int ind = n - 1; ind >= 0; ind--) {
			for (int prev_ind = ind - 1; prev_ind >= -1; prev_ind--) {
				int take = 0;
				if (prev_ind == -1 || nums[prev_ind] < nums[ind]) {
					take = 1 + dp[ind + 1][ind + 1];
				}
				int notTake = 0 + dp[ind + 1][prev_ind + 1];
				dp[ind][prev_ind + 1] = Math.max(take, notTake);
			}
		}
		return dp[0][0];

	}

	public static int optimal(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int maxi = 0;
		for (int i = 0; i < n; i++) {
			for (int prev = 0; prev < i; prev++) {
				if (nums[prev] < nums[i]) {
					dp[i] = Math.max(dp[i], 1 + dp[prev]);
				}
			}
			maxi = Math.max(maxi, dp[i]);
		}
		return maxi;
	}

	public static int lengthOfLIS(int[] nums) {
		int n = nums.length;
		int[][] dp = new int[n][n + 1];
		for (int[] d : dp) {
			Arrays.fill(d, -1);
		}
		return f(nums, n, 0, dp, -1);
	}

	public static void main(String[] args) {
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		int res = lengthOfLIS(nums);
		System.out.println(res);
		int tabulation = tabulation(nums);
		System.out.println(tabulation);
		int optimal = optimal(nums);
		System.out.println(optimal);
	}
}
