package com.akshay.dp.subSequence;

import java.util.Arrays;

public class LeetCode_322 {
	public static int f(int n, int[] coins, int amount, int[][] dp) {
		if (n == 0) {
			if ((amount % coins[n]) == 0) {
				return amount / coins[n];
			} else {
				return (int) Math.pow(10, 9);
			}
		}
		if (dp[n][amount] != -1) {
			return dp[n][amount];
		}
		int notTake = 0 + f(n - 1, coins, amount, dp);
		int take = (int) Math.pow(10, 9);
		if (coins[n] <= amount) {
			take = 1 + f(n, coins, amount - coins[n], dp);
		}
		return dp[n][amount] = Math.min(take, notTake);
	}
	
	public static int tabulation(int[] coins, int amount) {
		int n = coins.length;
		int[][] dp = new int[n][amount+1];
		if(amount % coins[0] == 0) {
			dp[0][coins[0]] = amount/coins[0];
		}
		for(int i=0;i<=amount;i++) {
			if(i% coins[0]==0) {
				dp[0][i] = i/coins[0];
			}
			else {
				dp[0][i] = (int) Math.pow(10, 9);
			}
		}
		
		for(int i=1;i<n;i++) {
			for(int j=1;j<=amount;j++) {
				int notTake = 0 + dp[i - 1][j];
				int take = (int) Math.pow(10, 9);
				if (coins[i] <= j) {
					take = 1 + dp[i][j - coins[i]];
				}
				dp[i][j] = Math.min(take, notTake);
			}
		}

		return dp[n-1][amount];
	}

	public static int coinChange(int[] coins, int amount) {
		int n = coins.length;
		int[][] dp = new int[n][amount + 1];
		for (int[] s : dp) {
			Arrays.fill(s, -1);
		}
		int ans = f(n - 1, coins, amount, dp);
		if (ans >= (int) Math.pow(10, 9))
			return -1;
		return ans;
	}

	public static void main(String[] args) {
		int[] coins = { 1, 2, 5 };
		int amount = 11;
		int coinChange = coinChange(coins,amount);
		System.out.println(coinChange);
		int res = tabulation(coins,amount);
		System.out.println(res);
	}
}
