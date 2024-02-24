package com.akshay.answers;

public class LeetCode_1539 {

	public static int findKthPositive(int[] arr, int k) {
		int low = 1;
		int high = arr.length - 1;
		int mid;
		while (low <= high) {
			mid = (low + high) / 2;
			int missing = arr[mid] - (mid + 1);
			if (missing < k) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return high + 1 + k;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 4, 7, 11 };
		int k = 5;
		int i = findKthPositive(arr, k);
		System.out.println(i);
	}
}
