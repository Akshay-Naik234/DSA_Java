package com.akshay.dp.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintLIS {
	public static List<Integer> printingLongestIncreasingSubsequence(int[] arr, int x) {
		int[] dp = new int[x];
		Arrays.fill(dp, 1);
		int[] hash = new int[x];
		int maxi = 0;
		int lastIndex = -1;
		for (int i = 0; i < x; i++) {
			hash[i] = i;
			for (int prev = 0; prev < i; prev++) {
				if (arr[prev] < arr[i] && 1 + dp[prev] > dp[i]) {
					dp[i] = 1 + dp[prev];
					hash[i] = prev;
				}
			}
			if (dp[i] > maxi) {
				maxi = dp[i];
				lastIndex = i;
			}
		}
		List<Integer> res = new ArrayList<>();
		res.add(arr[lastIndex]);
		while (hash[lastIndex] != lastIndex) {
			lastIndex = hash[lastIndex];
			res.add(arr[lastIndex]);
		}
		Collections.reverse(res);
		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 6, 3, 4, 7, 6 };
		int x = arr.length;
		List<Integer> res = printingLongestIncreasingSubsequence(arr, x);
		System.out.println(res);
	}
}
