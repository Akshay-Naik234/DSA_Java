package com.akshay.answers;

public class LeetCode_1283 {
	public static int findMax(int[] nums) {
		int max = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}
		}
		return max;
	}

	public static int func(int[] nums, int mid) {
		int t = 0;
		for (int i = 0; i < nums.length; i++) {
			t += Math.ceil((double) nums[i] / (double) mid);
		}
		return t;
	}

	public static int smallestDivisor(int[] nums, int threshold) {
		int low = 1;
		int high = findMax(nums);
		int mid;
		int ans = -1;
		while (low <= high) {
			mid = (low + high) / 2;
			int t = func(nums, mid);
			if (t <= threshold) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 5, 9 };
		int threshold = 6;
		System.out.println(smallestDivisor(nums, threshold));
	}
}
