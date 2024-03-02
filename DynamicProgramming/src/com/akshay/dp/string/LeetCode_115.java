package com.akshay.dp.string;

public class LeetCode_115 {
	public static int tabulation(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;// Important
		}
		for (int i = 1; i <= m; i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][m];
	}

	public static int numDistinct(String s, String t) {
		return tabulation(s, t);
	}

	public static void main(String[] args) {
		String s = "rabbbit";
		String t = "rabbit";
		int res = numDistinct(s, t);
		System.out.println(res);
	}
}
