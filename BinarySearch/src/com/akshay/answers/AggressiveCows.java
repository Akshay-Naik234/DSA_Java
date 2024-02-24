package com.akshay.answers;

import java.util.Arrays;

public class AggressiveCows {
	public static int func(int[] stalls, int k, int mid) {
		int last = stalls[0];
		int cnt = 1;
		for (int i = 1; i < stalls.length; i++) {
			if (stalls[i] - last >= mid) {
				last = stalls[i];
				cnt++;
			}
		}
		return cnt;
	}

	public static int aggressiveCows(int[] stalls, int k) {
		Arrays.sort(stalls);
		int n = stalls.length;
		int low = 1, high = stalls[n - 1] - stalls[0];
		int mid;
		int ans = -1;
		while (low <= high) {
			mid = (low + high) / 2;
			int cnt = func(stalls, k, mid);
			if (cnt < k) {
				high = mid - 1;
			} else {
				ans = mid;
				low = mid + 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 3, 4, 7, 10, 9 };
		int k = 4;
		int ans = aggressiveCows(arr, k);
		System.out.println(ans);
	}
}
