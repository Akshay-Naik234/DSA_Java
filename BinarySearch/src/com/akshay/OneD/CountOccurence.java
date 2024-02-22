package com.akshay.OneD;

public class CountOccurence {
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

	public static int count(int arr[], int n, int x) {
		int first = findFirstOccurence(arr, x);
		if (first == -1) {
			return 0;
		}
		int last = findLastOccurence(arr, x);
		return last - first + 1;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 4, 6, 8, 8, 8, 11, 13 };
		int count = count(arr, arr.length, 8);
		System.out.println(count);
	}
}
