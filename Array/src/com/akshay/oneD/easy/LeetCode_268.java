package com.akshay.oneD.easy;

public class LeetCode_268 {
	public static int missingNumber(int[] nums) {
		int n = nums.length;
		int xor1 = 0;
		int xor2 = 0;
		for (int i = 0; i < n; i++) {
			xor1 = xor1 ^ i;
			xor2 = xor2 ^ nums[i];
		}
		xor1 = xor1 ^ n;
		return xor1 ^ xor2;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 3 };
		System.out.println(missingNumber(nums));
	}
}
