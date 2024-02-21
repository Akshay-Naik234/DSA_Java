package com.akshay.oneD.easy;

import java.util.*;

public class LongestSubarrayWithSumKPart2 {

	public static int getLongestSubarray(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int maxLen = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum == k) {
				maxLen = Math.max(maxLen, i + 1);
			}
			int rem = sum - k;
			if (map.containsKey(rem)) {
				int len = i - map.get(rem);
				maxLen = Math.max(maxLen, len);
			}

			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return maxLen;
	}

	public static void main(String[] args) {
		int[] a = {1, 2, 1, 0, 1};
		int k = 4;
		System.out.println(getLongestSubarray(a,k));
	}
}
