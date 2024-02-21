package com.akshay.oneD.medium;

public class LeetCode_2149 {
	public static int[] rearrangeArray(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		int pIndex = 0, nIndex = 1;
		for (int i = 0; i < n; i++) {
			if (nums[i] < 0) {
				res[nIndex] = nums[i];
				nIndex += 2;
			} else {
				res[pIndex] = nums[i];
				pIndex += 2;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 1, -2, -5, 2, -4 };
		int[] array = rearrangeArray(nums);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
