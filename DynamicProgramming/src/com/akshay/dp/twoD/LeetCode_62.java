package com.akshay.dp.twoD;

public class LeetCode_62 {
	public static int f(int m, int n, int[][] dp) {
		if (m == 0 && n == 0) {
			return 1;
		}
		if (m < 0 || n < 0) {
			return 0;
		}
		if (dp[m][n] != -1) {
			return dp[m][n];
		}
		int left = f(m, n - 1, dp);
		int right = f(m - 1, n, dp);
		return dp[m][n] = left + right;
	}

	public static int tabulation(int m, int n, int[][] dp) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
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
				dp[i][j] = left + right;
			}
		}
		return dp[m - 1][n - 1];
	}

	public static void main(String[] args) {
		int m = 3;
		int n = 7;
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				dp[i][j] = -1;
			}
		}
		int res = tabulation(m, n, dp);
		System.out.println(res);
	}
}
