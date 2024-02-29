package com.akshay.dp.oneD;

public class FrogJumpKDistance {
	public static int f(int n, int k, int[] height, int[] dp) {
		if (n == 0) {
			return 0;
		}
		if (dp[n] != -1) {
			return dp[n];
		}
		int minJump = Integer.MAX_VALUE;
		for (int i = 1; i <= k; i++) {
			if (n - i >= 0) {
				int jump = f(n - i, k, height, dp) + Math.abs(height[n] - height[n - i]);
				minJump = Math.min(jump, minJump);
			}
		}
		return dp[n] = minJump;
	}

	public static int tabulation(int n, int k, int[] height, int[] dp) {
		dp[0] = 0;

		for (int i = 1; i <= n; i++) {
			int minJump = Integer.MAX_VALUE;
			for (int j = 1; j <= k; j++) {
				if (i - j >= 0) {
					int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
					minJump = Math.min(minJump, jump);
					dp[i] = minJump;
				}
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		int n = 3;
		int k = 1;
		int[] height = { 2, 5, 2 };
		int[] dp = new int[n + 1];
		for (int i = 0; i < n; i++) {
			dp[i] = -1;
		}
		int minimizeCost = tabulation(n - 1, k, height, dp);
		System.out.println(minimizeCost);

	}
}
