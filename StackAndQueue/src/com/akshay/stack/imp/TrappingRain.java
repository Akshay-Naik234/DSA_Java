package com.akshay.stack.imp;

public class TrappingRain {
	public static long getTrappedWater(long[] arr, int n) {
		int left = 0;
		int right = n - 1;
		long maxLeft = 0;
		long maxRight = 0;
		long res = 0;
		while (left < right) {
			if (arr[left] <= arr[right]) {
				if (arr[left] > maxLeft) {
					maxLeft = arr[left];
				} else {
					res += (maxLeft - arr[left]);
				}
				left++;
			} else {
				if (arr[right] > maxRight) {
					maxRight = arr[right];
				} else {
					res += (maxRight - arr[right]);
				}
				right--;
			}
		}
		return res;
	}

	public static void main(String[] args) {

		long[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		long res = getTrappedWater(arr, arr.length);
		System.out.println(res);
	}
}
