package com.akshay.OneD;

public class LeetCode_35 {
	public static int searchInsert(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		int mid;
		int ans = nums.length;

		while (low <= high) {
			mid = (low + high) / 2;
			if (nums[mid] >= target) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 10 };
		int x = 1;
		int lowerBound = searchInsert(arr, x);
		System.out.println(lowerBound);
	}
}
