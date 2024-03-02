package com.akshay.dp.MCM;

import java.util.*;

public class LeetCode_312 {
	public static int maxCoins(int[] nums) {
		int n = nums.length;
		List<Integer> cuts = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			cuts.add(nums[i]);
		}
		int[][] dp = new int[n + 2][n + 2];
		cuts.add(0, 1);
		cuts.add(1);
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= n; j++) {
				if (i > j)
					continue;

				int maxi = Integer.MIN_VALUE;

				for (int ind = i; ind <= j; ind++) {
					int ans = cuts.get(i - 1) * cuts.get(ind) * cuts.get(j + 1) + dp[i][ind - 1] + dp[ind + 1][j];
					maxi = Math.max(maxi, ans);
				}

				dp[i][j] = maxi;
			}
		}
		return dp[1][n];
	}

	public static void main(String[] args) {
		int[] b = { 3, 1, 5, 8 };
		int maxCoins = maxCoins(b);
		System.out.println(maxCoins);
	}
}
