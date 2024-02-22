package com.akshay.OneD;

public class LowerBound {
	public static int lowerBound(int[] arr, int n, int x) {
		int ans = n;
		int low = 0;
		int high = n - 1;
		int mid;
		if (x < arr[low]) {
			return 0;
		}

		while (low <= high) {
			mid = (low + high) / 2;
			if (arr[mid] >= x) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 1,2,3,4,5,10 };
		int x = 2;
		int lowerBound = lowerBound(arr, arr.length, x);
		System.out.println(lowerBound);
	}
}
