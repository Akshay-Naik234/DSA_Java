package com.akshay.answers;

public class LeetCode_1482 {
	public static int findMin(int[] bloomDay) {
		int mini = bloomDay[0];
		for (int i = 1; i < bloomDay.length; i++) {
			if (bloomDay[i] < mini) {
				mini = bloomDay[i];
			}
		}
		return mini;
	}

	public static int findMax(int[] bloomDay) {
		int maxi = bloomDay[0];
		for (int i = 1; i < bloomDay.length; i++) {
			if (bloomDay[i] > maxi) {
				maxi = bloomDay[i];
			}
		}
		return maxi;
	}

	public static boolean func(int[] bloomDay, int m, int k, int mid) {
		int n = bloomDay.length;
		int cnt = 0;
		int nthCnt = 0;
		for (int i = 0; i < n; i++) {
			if (bloomDay[i] <= mid) {
				cnt++;
			} else {
				nthCnt += cnt / k;
				cnt = 0;
			}
		}
		nthCnt += cnt / k;
		return nthCnt >= m;
	}

	public static int minDays(int[] bloomDay, int m, int k) {
		int low = findMin(bloomDay);
		int high = findMax(bloomDay);
		int mid;
		int ans = -1;
		while (low <= high) {
			mid = (low + high) / 2;
			boolean res = func(bloomDay, m, k, mid);
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
		int[] bloomDay = {1,10,3,10,2};
		int m= 3;
		int k= 1;
		System.out.println(minDays(bloomDay, m, k));
	}
}
