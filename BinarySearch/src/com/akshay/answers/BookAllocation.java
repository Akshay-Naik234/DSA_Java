package com.akshay.answers;

import java.util.ArrayList;

public class BookAllocation {
	public static int findMax(ArrayList<Integer> arr) {
		int mini = arr.get(0);
		for (int i = 1; i < arr.size(); i++) {
			if (arr.get(i) > mini) {
				mini = arr.get(i);
			}
		}
		return mini;
	}

	public static int findSum(ArrayList<Integer> arr) {
		int sum = 0;
		for (int i = 0; i < arr.size(); i++) {
			sum += arr.get(i);
		}
		return sum;
	}

	public static boolean func(ArrayList<Integer> arr, int n, int m, int mid) {
		int sum = 0;
		int cnt = 1;
		for (int i = 0; i < n; i++) {
			if (sum + arr.get(i) > mid) {
				cnt++;
				sum = arr.get(i);
			} else {
				sum = sum + arr.get(i);
			}
		}
		if (cnt <= m) {
			return true;
		}
		return false;
	}

	public static int findPages(ArrayList<Integer> arr, int n, int m) {
		if (m > n)
			return -1;
		int low = findMax(arr);
		int high = findSum(arr);
		int mid;
		int ans = -1;
		while (low <= high) {
			mid = (low + high) / 2;
			boolean res = func(arr, n, m, mid);
			if (res) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}
}
