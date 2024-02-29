package com.akshay.dp.twoD;

public class LeetCode_64 {
	public static int f(int n, int m, int[][] grid, int[][] dp) {
		if (m < 0 || n < 0) {
			return (int) Math.pow(10, 9);
		}

		if (n == 0 && m == 0) {
			return grid[n][m];
		}

		if (dp[n][m] != -1) {
			return dp[n][m];
		}

		int left = grid[n][m] + f(n, m - 1, grid, dp);
		int up = grid[n][m] + f(n - 1, m, grid, dp);

		return dp[n][m] = Math.min(left, up);
	}

	public static int tabulation(int n, int m, int[][] grid, int[][] dp) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i == 0 && j == 0) {
					dp[0][0] = grid[i][j];
				} else {
					int left = (int) Math.pow(10, 9);
					int up = (int) Math.pow(10, 9);
					if (j - 1 >= 0) {
						left = grid[i][j]+ dp[i][j - 1];
					}
					if (i - 1 >= 0) {
						up = grid[i][j]+ dp[i - 1][j];
					}
					dp[i][j] = Math.min(left, up);
				}

			}
		}
		return dp[n - 1][m - 1];
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		int n = grid.length;
		int m = grid[0].length;
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				dp[i][j] = -1;
			}
		}
		int res = f(n - 1, m - 1, grid, dp);
		System.out.println(res);

		int res1 = tabulation(n, m, grid, dp);
		System.out.println(res1);
	}

}
