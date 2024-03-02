package com.akshay.dp.stock;

import java.util.Arrays;

public class LeetCode_122 {
	public static int f(int[] prices, int n, int[][] dp, int buy, int i) {
		if (i == n) {
			return 0;
		}
		if (dp[i][buy] != -1) {
			return dp[i][buy];
		}
		int profit;
		if (buy == 0) {
			profit = Math.max(0 + f(prices, n, dp, 0, i + 1), -prices[i] + f(prices, n, dp, 1, i + 1));
		} else {
			profit = Math.max(0 + f(prices, n, dp, 1, i + 1), prices[i] + f(prices, n, dp, 0, i + 1));
		}
		dp[i][buy] = profit;
		return profit;
	}
	
	public static int tabulation(int[] prices) {
		int n = prices.length;
		int[][] dp = new int[n+1][2];
		
		for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
		dp[n][0]=0;
		dp[n][1]=0;
		int profit=0;
		for(int i=n-1;i>=0;i--) {
			for(int j=0;j<2;j++) {
				if (j == 0) {
					profit = Math.max(0 + dp[i + 1][0], -prices[i] + dp[i + 1][1]);
				} else {
					profit = Math.max(0 + dp[i + 1][1], prices[i] + dp[i + 1][0]);
				}
				dp[i][j] = profit;
			}
		}
		return dp[0][0];
	}

	public static int maxProfit(int[] prices) {
		int n = prices.length;
		int[][] dp = new int[n + 1][2];
		for (int[] d : dp) {
			Arrays.fill(d, -1);
		}
		return f(prices, n, dp, 0, 0);
	}
	
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		int maxProfit = maxProfit(prices);
		System.out.println(maxProfit);
		int tabulation = tabulation(prices);
		System.out.println(tabulation);
	}
}
