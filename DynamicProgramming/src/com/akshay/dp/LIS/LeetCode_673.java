package com.akshay.dp.LIS;

import java.util.Arrays;

public class LeetCode_673 {
	public static int findNumberOfLIS(int[] arr) {
		int x = arr.length;
		int[] dp = new int[x];
		int[] cnt = new int[x];
		Arrays.fill(dp, 1);
		Arrays.fill(cnt, 1);
		int maxi = 0;
		for (int i = 0; i < x; i++) {
			for (int prev = 0; prev < i; prev++) {
				if (arr[prev] < arr[i] && 1 + dp[prev] > dp[i]) {
					dp[i] = 1 + dp[prev];
					cnt[i] = cnt[prev];
				} else if (arr[prev] < arr[i] && 1 + dp[prev] == dp[i]) {
					cnt[i] = cnt[i] + cnt[prev];
				}
			}
			if (dp[i] > maxi) {
				maxi = dp[i];
			}
		}
		int res = 0;
		for (int i = 0; i < x; i++) {
			if (dp[i] == maxi) {
				res += cnt[i];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 4, 7 };
		int res = findNumberOfLIS(arr);
		System.out.println(res);
	}
}
