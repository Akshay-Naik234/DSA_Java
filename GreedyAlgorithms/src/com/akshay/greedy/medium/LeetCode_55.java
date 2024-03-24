package com.akshay.greedy.medium;

public class LeetCode_55 {
	public static boolean canJump(int[] nums) {
		int maxi = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (i > maxi) {
				return false;
			}
			maxi = Math.max(maxi, i + nums[i]);
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,3,1,1,4};
		boolean res = canJump(nums);
		System.out.println(res);
	}
}
