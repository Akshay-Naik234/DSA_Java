package com.akshay.dp.oneD;

public class LeetCode_198 {
	public static int f(int n, int[] nums, int[] dp) {

		if (n < 0)
			return 0;
		if (n == 0) {
			return nums[0];
		}
		if (dp[n] != -1) {
			return dp[n];
		}
		int take = nums[n] + f(n - 2, nums, dp);
		int notTake = 0 + f(n - 1, nums, dp);
		return dp[n] = Math.max(take, notTake);
	}

	public static int tabulation(int n, int[] nums, int[] dp) {
		dp[0] = nums[0];
		for (int i = 1; i <= n; i++) {
			int pick = nums[i];
			if (i > 1) {
				pick += dp[i - 2];
			}
			int notPick = dp[i - 1];
			dp[i] = Math.max(pick, notPick);
		}
		return dp[n - 1];
	}
	
	public static int optimal(int[] nums) {
		int n = nums.length;
		int prev1 = nums[0];
		int prev2 = 0;
		for(int i=1;i<n;i++) {
			int pick = nums[i];
			if(i>1) {
				pick += prev2;
			}
			int notPick = prev1;
			int cur = Math.max(pick, notPick);
			prev2 = prev1;
			prev1 = cur;
		}
		return prev1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1 };
		int n = nums.length;
		int[] dp = new int[n + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = -1;
		}
		int res = optimal(nums);
		System.out.println(res);
	}

}
