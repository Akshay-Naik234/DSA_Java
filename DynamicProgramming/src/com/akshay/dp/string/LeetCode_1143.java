package com.akshay.dp.string;

import java.util.*;

public class LeetCode_1143 {
	public int f(int n1, int n2, int[][] dp, String text1, String text2) {
		if (n1 < 0 | n2 < 0) {
			return 0;
		}

		if (dp[n1][n2] != -1) {
			return dp[n1][n2];
		}

		if (text1.charAt(n1) == text2.charAt(n2)) {
			return 1 + f(n1 - 1, n2 - 1, dp, text1, text2);
		}
		return dp[n1][n2] = Math.max(f(n1 - 1, n2, dp, text1, text2), f(n1, n2 - 1, dp, text1, text2));
	}
	
	public static int tabulation(String text1, String text2) {
		int n1 = text1.length();
		int n2 = text2.length();
		int[][] dp = new int[n1+1][n2+1];
		
		for (int rows[] : dp)
            Arrays.fill(rows, -1);
		
		for(int i =0;i<=n1;i++) {
			dp[i][0]=0;
		}
		for(int i=0;i<=n2;i++) {
			dp[0][i]=0;
		}
		for(int i=1;i<=n1;i++) {
			for(int j=1;j<=n2;j++) {
				if (text1.charAt(i-1) == text2.charAt(j-1)) {
					dp[i][j] =  1 + dp[i - 1][j - 1];
				}
				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
				
			}
		}
		return dp[n1][n2];
	}

	public int longestCommonSubsequence(String text1, String text2) {
		int n1 = text1.length();
		int n2 = text2.length();
		int[][] dp = new int[n1][n2];
		for (int[] i : dp) {
			Arrays.fill(i, -1);
		}
		return f(n1 - 1, n2 - 1, dp, text1, text2);
	}
	
	public static void main(String[] args) {
		String text1 = "abcde";
		String text2 = "ace";
		int tabulation = tabulation(text1,text2);
		System.out.println(tabulation);
	}
}
