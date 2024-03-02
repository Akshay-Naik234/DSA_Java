package com.akshay.dp.LIS;

import java.util.*;

public class LeetCode_368 {
	public static List<Integer> largestDivisibleSubset(int[] arr) {
		Arrays.sort(arr);
		int x = arr.length;
		int[] dp = new int[x];
		Arrays.fill(dp, 1);
		int[] hash = new int[x];
		int maxi = 0;
		int lastIndex = -1;
		for (int i = 0; i < x; i++) {
			hash[i] = i;
			for (int prev = 0; prev < i; prev++) {
				if ((arr[i] % arr[prev] == 0) && 1 + dp[prev] > dp[i]) {
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
		int[] arr = {1,2,3};
		List<Integer> res = largestDivisibleSubset(arr);
		System.out.println(res);
	}
}
