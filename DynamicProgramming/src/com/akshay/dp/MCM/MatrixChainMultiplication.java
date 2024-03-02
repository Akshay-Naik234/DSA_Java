package com.akshay.dp.MCM;

import java.util.Arrays;

public class MatrixChainMultiplication {

	public static int f(int i, int j, int[] p, int[][] dp) {
		if (i == j) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		int mini = Integer.MAX_VALUE;
		for (int k = i; k <= j - 1; k++) {
			int ans = f(i, k, p, dp) + f(k + 1, j, p, dp) + p[i - 1] * p[k] * p[j];
			if (ans < mini) {
				mini = ans;
			}
		}
		return mini;
	}

	public static int tabulation(int[] p) {
		int n = p.length;
		int[][] dp = new int[n][n];
		for (int[] d : dp) {
			Arrays.fill(d, -1);
		}
		for(int i=1;i<n;i++) {
			dp[i][i]=0;
		}
		
		for (int i = n - 1; i >= 1; i--) {
			for (int j = i+1; j < n; j++) {
				int mini = Integer.MAX_VALUE;
				for (int k = i; k <= j - 1; k++) {
					int ans = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
					if (ans < mini) {
						mini = ans;
					}
				}
				dp[i][j] = mini;
			}
		}
		return dp[1][n-1];
	}

	public static int mcm(int[] p) {
		int n = p.length;
		int i = 1;
		int j = n - 1;
		int[][] dp = new int[n][n];
		for (int[] d : dp) {
			Arrays.fill(d, -1);
		}
		return f(i, j, p, dp);
	}

	public static void main(String[] args) {
		int[] p = { 10, 15, 20, 25 };
		System.out.println(mcm(p));
		System.out.println(tabulation(p));
	}
}
