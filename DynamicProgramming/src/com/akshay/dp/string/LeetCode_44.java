package com.akshay.dp.string;

import java.util.Arrays;

public class LeetCode_44 {

	public static boolean isAllStarts(String s, int i) {
		for (int j = 0; j <= i; j++) {
			if (s.charAt(j) != '*') {
				return false;
			}
		}
		return true;
	}

	public static int tabulation(String s, String p, int i, int j, int[][] dp) {
		if (i < 0 && j < 0) {
			return 1;
		}
		if (i < 0 && j >= 0) {
			return isAllStarts(p, j) == true ? 1 : 0;
		}
		if (j < 0 && i >= 0) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		if ((s.charAt(i) == p.charAt(j) || (p.charAt(j) == '?'))) {
			return dp[i][j] = tabulation(s, p, i - 1, j - 1, dp);
		} else {
			if (p.charAt(j) == '*') {
				return dp[i][j] = (tabulation(s, p, i - 1, j, dp) | tabulation(s, p, i, j - 1, dp));
			} else {
				return 0;
			}
		}
	}

	public static boolean isMatch(String s, String p) {
		int n1 = s.length();
		int n2 = p.length();
		int[][] dp = new int[n1 + 1][n2 + 1];
		for (int[] is : dp) {
			Arrays.fill(is, -1);
		}
		boolean tabulation = tabulation(s, p, n1 - 1, n2 - 1, dp) == 1 ? true : false;
		return tabulation;
	}

	public static void main(String[] args) {
		boolean match = isMatch("aa", "*");
		System.out.println(match);
	}
}
