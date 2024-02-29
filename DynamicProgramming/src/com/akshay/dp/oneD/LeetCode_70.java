package com.akshay.dp.oneD;

public class LeetCode_70 {
	public static int f(int n, int[] dp) {
		if (n == 0) {
			return 1;
		}
		if (dp[n] != -1) {
			return dp[n];
		}
		int oneStep = f(n - 1, dp);
		int twoStep = 0;
		if (n > 1) {
			twoStep = f(n - 2, dp);
		}
		return dp[n] = oneStep + twoStep;
	}
	
	public static int tabulation(int n,int[] dp) {
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2;i<=n;i++) {
			dp[i] = dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
	
	public static void main(String[] args) {
		int n = 6;
		int dp[] = new int[n+1];
        for(int i=0;i<dp.length;i++){
            dp[i] = -1;
        }
        int res =  tabulation(n,dp);
        System.out.println(res);
	}
}
