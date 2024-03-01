package com.akshay.dp.subSequence;

import java.util.Arrays;

public class RodCutting {

	public static int f(int[] price, int n, int[][] dp, int w) {
		if (n == 0 && w>0) {
			return price[0] * w;
		}
		else if(n==0) {
			return 0;
		}
		if (dp[n][w] != -1) {
			return dp[n][w];
		}
		int take = Integer.MIN_VALUE;
		int rodLength = n+1;
		if (rodLength <= w) {
			take = price[n] + f(price, n, dp, w - rodLength);
		}
		int notTake = f(price, n - 1, dp, w);
		return dp[n][w] = Math.max(take, notTake);
	}

	public static int cutRod(int[] price, int n) {
		int[][] dp = new int[n + 1][n + 1];
		for (int[] is : dp) {
			Arrays.fill(is, -1);
		}
		return f(price, n-1, dp, n);
	}

	public static void main(String[] args) {
		int[] price = { 2, 5, 7, 8, 10 };
		int n = price.length;
		int cutRod = cutRod(price, n);
		System.out.println(cutRod);
	}
}
