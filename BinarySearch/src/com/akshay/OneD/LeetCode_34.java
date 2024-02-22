package com.akshay.OneD;

public class LeetCode_34 {
	public static int findFirstOccurence(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		int ans = -1;
		int mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (nums[mid] == target) {
				ans = mid;
				high = mid - 1;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}

	public static int findLastOccurence(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		int ans = -1;
		int mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (nums[mid] == target) {
				ans = mid;
				low = mid + 1;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}

	public static int[] searchRange(int[] nums, int target) {
		int[] res = new int[] { -1, -1 };
		res[0] = findFirstOccurence(nums, target);
		res[1] = findLastOccurence(nums, target);
		return res;
	}

	public static void main(String[] args) {
		int[] arr= new int[] {5,7,7,8,8,10};
		int[] searchRange = searchRange(arr, 8);
		System.out.println("["+searchRange[0] + ","+searchRange[1]+"]");
	}
}
