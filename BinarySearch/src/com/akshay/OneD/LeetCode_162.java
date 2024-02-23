package com.akshay.OneD;

public class LeetCode_162 {
	public static int findPeakElement(int[] nums) {
		int n = nums.length;
		if (n == 1) {
			return 0;
		}
		if (nums[0] > nums[1]) {
			return 0;
		}
		if (nums[n - 1] > nums[n - 2]) {
			return n - 1;
		}
		int low = 1;
		int high = n - 2;
		int mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
				return mid;
			} else if (nums[mid] > nums[mid - 1]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,2,3,1};
		int peakElement = findPeakElement(nums);
		System.out.println(peakElement);
	}
}
