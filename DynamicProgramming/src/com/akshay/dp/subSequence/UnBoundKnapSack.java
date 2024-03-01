package com.akshay.dp.subSequence;

public class UnBoundKnapSack {

	public static int tabulation(int n, int w, int[] profit, int[] weight) {
		int[][] dp = new int[n][w+1];
		for(int i=0;i<=w;i++) {
			if(i%weight[0] == 0) {
				dp[0][i] = (i/weight[0])* profit[0] ;
			}
		}
		for(int i=1;i<n;i++) {
			for(int j=0;j<=w;j++) {
				int take = Integer.MIN_VALUE;
				if (weight[i] <= j) {
					take = dp[i][j - weight[i]] + profit[i];
				}
				int notTake = dp[i - 1][j];
				dp[i][j] = Math.max(take, notTake);
			}
		}
		return dp[n-1][w];
	}

	public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
		return tabulation(n, w, profit, weight);
	}
	
	public static void main(String[] args) {
		int[] profit= {5, 11, 13};
		int[] weight = {2, 4, 6};
		int res = unboundedKnapsack(3,10,profit,weight);
		System.out.println(res);
	}
}
