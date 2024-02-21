package com.akshay.oneD.medium;

public class LeetCode_169 {

	public static int majorityElement(int[] nums) {
		int el = 0;
		int count = 0;
		int cnt1 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (count == 0) {
				count++;
				el = nums[i];
			} else if (el == nums[i]) {
				count++;
			} else {
				count--;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == el) {
				cnt1++;
			}
		}
		if (cnt1 > (nums.length / 2)) {
			return el;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		System.out.println(majorityElement(nums));
	}
}
