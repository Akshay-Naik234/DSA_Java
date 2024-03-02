package com.akshay.dp.string;

public class LeetCode_72 {
	public static int tabulation(String word1, String word2) {
		int n1 = word1.length();
		int n2 = word2.length();
		int[][] dp = new int[n1 + 1][n2 + 1];
		//Initialization imp
		for (int i = 0; i <= n1; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= n2; j++) {
			dp[0][j] = j;
		}
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					
					//+1 imp
					dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
				}
			}
		}
		return dp[n1][n2];
	}

	public static int minDistance(String word1, String word2) {
		return tabulation(word1, word2);
	}
	
	public static void main(String[] args) {
		String word1 = "horse";
		String word2 = "ros";
		int res = minDistance(word1, word2);
		System.out.println(res);
	}
}
