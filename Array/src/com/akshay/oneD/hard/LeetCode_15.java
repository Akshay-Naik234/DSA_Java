package com.akshay.oneD.hard;

import java.util.*;

public class LeetCode_15 {
	
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			int j = i + 1;
			int k = n - 1;
			if (i > 0 && nums[i - 1] == nums[i]) {
				continue;
			}
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum < 0) {
					j++;
				} else if (sum > 0) {
					k--;
				} else {
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[i]);
					temp.add(nums[j]);
					temp.add(nums[k]);
					res.add(temp);
					j++;
					k--;
					while (j < k && nums[j] == nums[j - 1]) {
						j++;
					}
					while (j < k && nums[k] == nums[k + 1]) {
						k--;
					}
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		List<List<Integer>> threeSum = threeSum(nums);
		for (List<Integer> list : threeSum) {
			System.out.println(list.toString());
		}
	}
}
