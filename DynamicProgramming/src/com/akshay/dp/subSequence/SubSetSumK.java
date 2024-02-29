package com.akshay.dp.subSequence;

public class SubSetSumK {
	public static boolean f(int n, int k, int[] arr, boolean[][] dp) {
		if (k == 0) {
			return true;
		}
		if (n == 0) {
			return arr[n] == k;
		}
		if (dp[n][k]) {
			return dp[n][k];
		}
		boolean pick = false;
		if (arr[n] <= k) {
			pick = f(n - 1, k - arr[n], arr, dp);
		}

		boolean notPick = f(n - 1, k, arr, dp);
		return dp[n][k] = pick || notPick;
	}

	public static boolean tabulation(int n, int k, int[] arr, boolean[][] dp) {
		for (int i = 0; i < n; i++) {
			dp[i][0] = true;
		}
		if (arr[0] <= k) {
			dp[0][arr[0]] = true;
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				boolean notPick = dp[i - 1][j];
				boolean pick = false;
				if (arr[i] <= j) {
					pick = dp[i - 1][j - arr[i]];
				}

				dp[i][j] = pick || notPick;
			}
		}

		return dp[n - 1][k];
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4 };
		int n = 4;
		int k = 4;
		boolean[][] dp = new boolean[n + 1][k + 1];
		boolean res = f(n - 1, k, arr, dp);

		System.out.println(res);
		boolean res1 = tabulation(n, k, arr, dp);
		System.out.println(res1);
	}

}
