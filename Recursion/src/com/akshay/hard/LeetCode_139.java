package com.akshay.hard;

import java.util.*;

public class LeetCode_139 {
	public static boolean wordBreak(String s, List<String> wordDict) {
		int n = s.length();
		int[][] dp = new int[n][n];
		for (int[] i : dp) {
			Arrays.fill(i, -1);
		}
		return solve(0, 0, s, new HashSet<>(wordDict), dp);
	}

	public static boolean solve(int start, int end, String s, Set<String> wd, int[][] dp) {
		if (dp[start][end] != -1) {
			return dp[start][end] == 1 ? true : false;
		}
		if (end == s.length() - 1) {
			if (wd.contains(s.substring(start, end + 1))) {
				return true;
			} else {
				return false;
			}
		}
		if (wd.contains(s.substring(start, end + 1))) {
			if (solve(end + 1, end + 1, s, wd, dp)) {
				dp[start][end] = 1;
				return true;
			}
		}

		dp[start][end] = solve(start, end + 1, s, wd, dp) == true ? 1 : 0;
		return dp[start][end] == 1 ? true : false;
	}
	
	public static void main(String[] args) {
		String s = "leetcode";
		List<String> wordDict = new ArrayList<>();
		wordDict.add("leet");
		wordDict.add("code");
		boolean res = wordBreak(s, wordDict);
		System.out.println(res);
	}
}
