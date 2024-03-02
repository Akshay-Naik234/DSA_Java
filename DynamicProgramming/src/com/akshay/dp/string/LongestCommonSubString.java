package com.akshay.dp.string;

import java.util.Arrays;

public class LongestCommonSubString {

	public static int tabulation(String text1, String text2) {
		int n1 = text1.length();
		int n2 = text2.length();
		int[][] dp = new int[n1 + 1][n2 + 1];

		for (int rows[] : dp)
			Arrays.fill(rows, -1);

		for (int i = 0; i <= n1; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i <= n2; i++) {
			dp[0][i] = 0;
		}
		int ans = 0;
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
					ans = Math.max(ans, dp[i][j]);
				} else {
					dp[i][j] = 0;
				}

			}
		}
		return ans;
	}

	public static int lcs(String s1, String s2) {
		return tabulation(s1, s2);
	}

	public static void main(String[] args) {
		String s1 = "abcjklp";
		String s2 = "acjkp";
		int res = lcs(s1, s2);
		System.out.println(res);

	}
}
