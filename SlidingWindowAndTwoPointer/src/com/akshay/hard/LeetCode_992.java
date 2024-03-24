package com.akshay.hard;

import java.util.*;

public class LeetCode_992 {
	public static int subarraysWithKDistinct(int[] nums, int k) {
		return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
	}

	public static int atMostKDistinct(int[] nums, int k) {
		int start = 0;
		int res = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int end = 0; end < nums.length; end++) {
			map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
			while (map.size() > k) {
				if (map.get(nums[start]) > 1) {
					map.put(nums[start], map.getOrDefault(nums[start], 0) - 1);
				} else {
					map.remove(nums[start]);
				}
				start++;
			}
			res += end - start + 1;
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums = {1,2,1,2,3};
		int res = subarraysWithKDistinct(nums, 2);
		System.out.println(res);
	}
}
