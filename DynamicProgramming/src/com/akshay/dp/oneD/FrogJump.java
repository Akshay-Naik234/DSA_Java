package com.akshay.dp.oneD;

public class FrogJump {
	public static int f(int n, int[] heights, int[] dp) {
		if (n == 0) {
			return 0;
		}
		if (dp[n] != -1) {
			return dp[n];
		}
		int oneStep = Math.abs(heights[n] - heights[n - 1]) + f(n - 1, heights, dp);
		int twoStep = Integer.MAX_VALUE;
		if (n > 1) {
			twoStep = Math.abs(heights[n] - heights[n - 2]) + f(n - 2, heights, dp);
		}
		return dp[n] = Math.min(oneStep, twoStep);
	}
	
	public static int tabulation(int n,int[] heights,int[] dp) {
		dp[0] = 0;
		for(int i =1;i<=n;i++) {
			int oneStep = Math.abs(heights[i] - heights[i - 1]) + dp[i-1];
			int twoStep = Integer.MAX_VALUE;
			if (i > 1) {
				twoStep = Math.abs(heights[i] - heights[i - 2]) + dp[i-2];
			}
			dp[i] = Math.min(oneStep, twoStep);
		}
		return dp[n];
	}

	public static void main(String[] args) {
		int n = 4;
		int heights[] = { 10, 20, 30, 10 };
		int dp[] = new int[n + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		int res = f(n - 1, heights, dp);
		System.out.println(tabulation(n - 1, heights, dp));
	}
}
