package com.akshay.dp.twoD;

import java.util.*;

public class LeetCode_120 {
	public static int f(int n, int m, List<List<Integer>> triangle, int[][] dp, int i, int j) {
		if (i == n - 1) {
			return dp[i][j] = triangle.get(i).get(j);
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		int down = triangle.get(i).get(j) + f(n, m, triangle, dp, i + 1, j);
		int cross = triangle.get(i).get(j) + f(n, m, triangle, dp, i + 1, j + 1);
		return dp[n - 1][m - 1] = Math.min(down, cross);
	}

	public static int tabulation(int n, int m, List<List<Integer>> triangle, int[][] dp) {
		for (int k = 0; k < m; k++) {
			dp[n - 1][k] = triangle.get(n - 1).get(k);
		}
		for (int i = n - 2; i >= 0; i--) {
			for (int j = i; j >= 0; j--) {

				int down = (int) Math.pow(10, 9);
				int cross = (int) Math.pow(10, 9);
				if (i + 1 >= 0) {
					down = triangle.get(i).get(j) + f(n, m, triangle, dp, i + 1, j);
				}
				if (i + 1 >= 0 && j + 1 >= 0) {
					cross = triangle.get(i).get(j) + f(n, m, triangle, dp, i + 1, j + 1);
				}
				dp[i][j] = Math.min(down, cross);
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {

		List<List<Integer>> triangle = new ArrayList<>(
				Arrays.asList(new ArrayList<>(Arrays.asList(2)), new ArrayList<>(Arrays.asList(3, 4)),
						new ArrayList<>(Arrays.asList(6, 5, 7)), new ArrayList<>(Arrays.asList(4, 1, 8, 3))));
		int n = triangle.size();
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				dp[i][j] = -1;
			}
		}
		int res = f(n, n, triangle, dp, 0, 0);
		System.out.println(res);

		int res1 = tabulation(n, n, triangle, dp);
		System.out.println(res1);
	}
}
