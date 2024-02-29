package com.akshay.dp.twoD;

public class LeetCode_63 {
	public static int f(int n, int m, int[][] obstacleGrid, int[][] dp) {
		if (m >= 0 && n >= 0 && obstacleGrid[n][m] == 1) {
			return 0;
		}

		if (n < 0 || m < 0) {
			return 0;
		}

		if (n == 0 && m == 0) {
			return 1;
		}

		if (dp[n][m] != -1) {
			return dp[n][m];
		}
		int left = f(n, m - 1, obstacleGrid, dp);
		int right = f(n - 1, m, obstacleGrid, dp);
		return dp[n][m] = left + right;
	}

	public static int tabulation(int n, int m, int[][] obstacleGrid, int[][] dp) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {

				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;
					continue;
				}

				if (i == 0 && j == 0) {
					dp[i][j] = 1;
					continue;
				}

				int left = 0;
				int right = 0;
				if (j - 1 >= 0) {
					left = dp[i][j - 1];
				}
				if (i - 1 >= 0) {
					right = dp[i - 1][j];
				}
				dp[i][j] = right + left;
			}
		}
		return dp[n - 1][m - 1];
	}

	public static void main(String[] args) {
		int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int n = obstacleGrid.length;
		int m = obstacleGrid[0].length;
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				dp[i][j] = -1;
			}
		}
		int res = f(n - 1, m - 1, obstacleGrid, dp);
		System.out.println(res);
		int res1 = tabulation(n, m, obstacleGrid, dp);
		System.out.println(res1);
	}
}
