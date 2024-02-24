package com.akshay.answers;

public class SquareRootOfNumber {
	public static boolean findSqrt(Long N, Long mid) {
		if (mid * mid <= N) {
			return true;
		}
		return false;
	}

	public static int sqrtN(long N) {
		long low = 1;
		long high = N;
		long mid;
		int ans = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (findSqrt(N, mid) == true) {
				ans = (int) mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int sqrtN = sqrtN(7);
		System.out.println(sqrtN);
	}
}
