package com.akshay.oneD.easy;

public class LeetCode_189 {
	public static void rotate(int[] nums, int k) {

		int n = nums.length;
		if (n == 0) {
			return;
		}
		k = k % n;
		int[] temp = new int[k];
		for (int i = n - k; i < n; i++) {
			temp[i + k - n] = nums[i];
		}

		for (int i = n - k - 1; i >= 0; i--) {
			nums[i + k] = nums[i];
		}
		for (int i = 0; i < k; i++) {
			nums[i] = temp[i];
		}
	}

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		rotate(nums, k);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
