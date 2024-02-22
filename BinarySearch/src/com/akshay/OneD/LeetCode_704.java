package com.akshay.OneD;

public class LeetCode_704 {
	public static int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		int mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		int target = 4;
		System.out.println(search(nums, target));
	}
}
