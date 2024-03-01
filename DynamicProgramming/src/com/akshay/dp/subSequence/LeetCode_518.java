package com.akshay.dp.subSequence;

import java.util.Arrays;

public class LeetCode_518 {
	public static int f(int n, int amount, int[] coins, int[][] dp) {
		if (n == 0) {
			if (amount % coins[0] == 0) {
				return 1;
			} else {
				return 0;
			}
		}
		if (dp[n][amount] != -1) {
			return dp[n][amount];
		}
		int take = 0;
		if (coins[n] <= amount) {
			take = f(n, amount - coins[n], coins, dp);
		}
		int notTake = f(n - 1, amount, coins, dp);
		return dp[n][amount] = take + notTake;
	}
	
	public static int tabulation(int n, int amount, int[] coins) {
		int[][] dp = new int[n][amount+1];
		for(int i=0;i<=amount;i++) {
			if(i%coins[0] == 0) {
				dp[0][i] = 1;
			}
			
		}
		for(int i=1;i<n;i++) {
			for(int j=0;j<=amount;j++) {
				int take = 0;
				if (coins[i] <= j) {
					take = dp[i][j - coins[i]];
				}
				int notTake = dp[i - 1][j];
				dp[i][j] = take + notTake;
			}
		}
		return dp[n-1][amount];
	}

	public static int change(int amount, int[] coins) {
		int n = coins.length;
		int[][] dp = new int[n][amount + 1];
		for (int[] d : dp) {
			Arrays.fill(d, -1);
		}
		return f(n - 1, amount, coins, dp);
	}
	
	public static void main(String[] args) {
		int amount = 5;
		int[] coins = {1,2,5};
		int res = change(amount, coins);
		System.out.println(res);
		
		int tabulation = tabulation(coins.length,amount,coins);
		System.out.println(tabulation);
	}
}
