package com.akshay.greedy.medium;

public class LeetCode_45 {
	public static int jump(int[] nums) {
		if (nums.length <= 2) {
			return nums.length - 1;
		}
		int maxi = nums[0];
		int end = nums[0];
		int cnt = 1;
		for (int i = 1; i < nums.length - 1; i++) {
			maxi = Math.max(maxi, i + nums[i]);
			if (i == end) {
				end = maxi;
				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };
		int res = jump(nums);
		System.out.println(res);
	}
}
