package com.akshay.oneD.hard;

import java.util.*;

public class LargestSubArraySum0 {
	public static int getLongestZeroSumSubarrayLength(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		int maxi = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum == 0) {
				maxi = i + 1;
			} else {
				if (map.get(sum) != null) {
					maxi = Math.max(maxi, i - map.get(sum));
				} else {
					map.put(sum, i);
				}
			}
		}
		return maxi;
	}

	public static void main(String[] args) {
		int[] arr = { 1, -1, 0, 0, 1 };
		int length = getLongestZeroSumSubarrayLength(arr);
		System.out.println(length);
	}
}
