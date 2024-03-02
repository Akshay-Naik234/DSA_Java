package com.akshay.dp.LIS;

import java.util.Arrays;

public class LongestBitonicSubSequence {
	public static int longestBitonicSequence(int[] arr, int n) {
		int[] dp1 = new int[n];
		int[] dp2 = new int[n];
		Arrays.fill(dp1, 1);
		Arrays.fill(dp2, 1);
		for (int i = 0; i < n; i++) {
			for (int prev = 0; prev < i; prev++) {
				if (arr[prev] < arr[i] && 1 + dp1[prev] > dp1[i]) {
					dp1[i] = 1 + dp1[prev];
				}
			}
		}
		for (int i = n - 1; i >= 0; i--) {
			for (int prev = n - 1; prev > i; prev--) {
				if (arr[prev] < arr[i] && 1 + dp2[prev] > dp2[i]) {
					dp2[i] = 1 + dp2[prev];
				}
			}
		}
		int maxi = -1;
		for (int i = 0; i < n; i++) {
			maxi = Math.max(dp1[i] + dp2[i] - 1, maxi);
		}

		return maxi;
	}
	
	public static void main(String[] args) {
		int[] arr= {1, 2, 1, 2, 1};
		int res = longestBitonicSequence(arr,arr.length);
		System.out.println(res);
	}
}
