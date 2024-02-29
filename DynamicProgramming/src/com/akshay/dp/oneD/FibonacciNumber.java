package com.akshay.dp.oneD;

import java.util.Scanner;

public class FibonacciNumber {

	// Memorization
	public static int f(int n, int[] dp) {
		if (n <= 1) {
			return n;
		}
		if (dp[n] != -1) {
			return dp[n];
		}
		return dp[n] = f(n - 1, dp) + f(n - 2, dp);
	}

	// Tabulation
	public static int tabulation(int n, int[] dp) {
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	// Optimal
	public static int optimal(int n) {
		int prev2 = 0;
		int prev1 = 1;
		for (int i = 2; i <= n; i++) {
			int cur = prev1 + prev2;
			prev2 = prev1;
			prev1 = cur;
		}
		return prev1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int dp[] = new int[n + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}

		int res = f(n, dp);
		System.out.println(res);

		int tabulation = tabulation(n, dp);
		System.out.println(tabulation);

		int optimal = optimal(n);
		System.out.println(optimal);
	}
}
