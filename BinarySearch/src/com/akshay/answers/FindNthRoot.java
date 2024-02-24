package com.akshay.answers;

public class FindNthRoot {
	public static int findNthRoot(int n, int mid, int m) {
		long prod = 1;
		for (int i = 1; i <= n; i++) {
			prod = prod * mid;
			if (prod > m) {
				return 2;
			}
		}
		if (prod == m) {
			return 1;
		}
		return 0;
	}

	public static int NthRoot(int n, int m) {
		int low = 1;
		int high = m;
		int mid;
		int ans = -1;
		while (low <= high) {
			mid = (low + high) / 2;
			int midN = findNthRoot(n, mid, m);
			if (midN == 1) {
				return mid;
			} else if (midN == 0) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int nthRoot = NthRoot(9, 1953125);
		System.out.println(nthRoot);
	}
}
