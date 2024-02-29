package com.akshay.dp.oneD;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_213 {
	
	public static int rob(int[] nums) {
		List<Integer> arr1 = new ArrayList<>();
		List<Integer> arr2 = new ArrayList<>();

		if (nums.length == 1) {
			return nums[0];
		}
		for (int i = 0; i < nums.length; i++) {
			if (i != 0) {
				arr1.add(nums[i]);
			}
			if (i != nums.length - 1) {
				arr2.add(nums[i]);
			}
		}
		return Math.max(optimal(arr1), optimal(arr2));
	}

	public static int optimal(List<Integer> nums) {
		int n = nums.size();
		int prev1 = nums.get(0);
		int prev2 = 0;
		for (int i = 1; i < n; i++) {
			int pick = nums.get(i);
			if (i > 1) {
				pick += prev2;
			}
			int notPick = prev1;
			int cur = Math.max(pick, notPick);
			prev2 = prev1;
			prev1 = cur;
		}
		return prev1;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 2 };
		int rob = rob(nums);
		System.out.println(rob);
	}
}
