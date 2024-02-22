package com.akshay.OneD;

public class LeetCode_153 {
	public static int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;
		int mid;
		int mini = Integer.MAX_VALUE;
		while (low <= high) {
			mid = (low + high) / 2;
			if (nums[low] <= nums[high]) {
				mini = Math.min(mini, nums[low]);
				break;
			}
			if (nums[low] <= nums[mid]) {
				mini = Math.min(mini, nums[low]);
				low = mid + 1;
			} else {
				mini = Math.min(mini, nums[mid]);
				high = mid - 1;
			}
		}
		return mini;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 3, 4, 5, 1, 2 };
		int min = findMin(nums);
		System.out.println(min);
	}
}
