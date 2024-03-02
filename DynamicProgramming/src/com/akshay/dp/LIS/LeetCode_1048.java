package com.akshay.dp.LIS;

import java.util.Arrays;

public class LeetCode_1048 {
	public static boolean compare(String s1, String s2) {
		if (s1.length() != s2.length() + 1) {
			return false;
		}
		int first = 0;
		int second = 0;
		while (first < s1.length()) {
			if ((second < s2.length()) && (s1.charAt(first) == s2.charAt(second))) {
				first++;
				second++;
			} else {
				first++;
			}
		}
		return (first == s1.length()) && (second == s2.length());
	}

	public static int longestStrChain(String[] words) {
		Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
		int n = words.length;
		int maxi = 1;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		for (int i = 0; i < n; i++) {
			for (int prev = 0; prev < i; prev++) {
				if (compare(words[i], words[prev]) && 1 + dp[prev] > dp[i]) {
					dp[i] = 1 + dp[prev];
				}
			}
			maxi = Math.max(maxi, dp[i]);
		}
		return maxi;
	}

	public static void main(String[] args) {
		String[] words = { "xbc", "pcxbcf", "xb", "cxbc", "pcxbc" };
		System.out.println(longestStrChain(words));
	}
}
