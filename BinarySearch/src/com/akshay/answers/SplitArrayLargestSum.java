package com.akshay.answers;

public class SplitArrayLargestSum {
	public static int findMax(int[] a) {
		int mini = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > mini) {
				mini = a[i];
			}
		}
		return mini;
	}

	public static int findSum(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}

	public static boolean func(int[] a, int k, int mid) {
		int sum = 0;
		int cnt = 1;
		for (int i = 0; i < a.length; i++) {
			if (sum + a[i] > mid) {
				cnt++;
				sum = a[i];
			} else {
				sum += a[i];
			}
		}
		if (cnt <= k) {
			return true;
		}
		return false;
	}

	public static int largestSubarraySumMinimized(int[] a, int k) {
		int low = findMax(a);
		int high = findSum(a);
		int mid;
		int ans = -1;
		while (low <= high) {
			mid = (low + high) / 2;
			boolean res = func(a, k, mid);
			if (res) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		int k = 3;
		System.out.println(largestSubarraySumMinimized(a,k));
	}
}
