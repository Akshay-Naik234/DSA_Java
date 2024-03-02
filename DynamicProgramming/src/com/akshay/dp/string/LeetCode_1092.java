package com.akshay.dp.string;

import java.util.Arrays;

public class LeetCode_1092 {
	public static String reverse(String s) {
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			res = s.charAt(i) + res;
		}
		return res;
	}

	public static String tabulation(String text1, String text2) {
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
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}

			}
		}
		int i = n1;
		int j = n2;
		String ans = "";
		while (i > 0 && j > 0) {
			if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
				ans = ans + text1.charAt(i - 1);
				i--;
				j--;
			} else if (dp[i - 1][j] >= dp[i][j - 1]) {
				ans = ans + text1.charAt(i - 1);
				i--;
			} else {
				ans = ans + text2.charAt(j - 1);
				j--;
			}
		}
		while (i > 0) {
			ans = ans + text1.charAt(i - 1);
			i--;
		}
		while (j > 0) {
			ans = ans + text2.charAt(j - 1);
			j--;
		}

		return reverse(ans);
	}

	public static String shortestCommonSupersequence(String str1, String str2) {
		return tabulation(str1, str2);
	}

	public static void main(String[] args) {
		String str1 = "abac";
		String str2 = "cab";
		System.out.println(shortestCommonSupersequence(str1, str2));

	}
}
