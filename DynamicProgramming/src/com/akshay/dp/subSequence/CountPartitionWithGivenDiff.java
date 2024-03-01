package com.akshay.dp.subSequence;

public class CountPartitionWithGivenDiff {
	static int findWays(int[] num, int tar) {
		int n = num.length;
		int dp[][] = new int[n][tar + 1];
		if (num[0] == 0)
			dp[0][0] = 2;
		else
			dp[0][0] = 1;

		if (num[0] != 0 && num[0] <= tar)
			dp[0][num[0]] = 1;
		for (int ind = 1; ind < n; ind++) {
			for (int target = 0; target <= tar; target++) {
				int notTaken = dp[ind - 1][target];
				int taken = 0;
				if (num[ind] <= target)
					taken = dp[ind - 1][target - num[ind]];

				dp[ind][target] = (notTaken + taken);
			}
		}
		return dp[n - 1][tar];
	}

	public static int countPartitions(int n, int d, int[] arr) {
		int totSum = 0;
		for (int i = 0; i < n; i++) {
			totSum += arr[i];
		}
		if (totSum - d < 0 || (totSum - d) % 2 == 1)
			return 0;
		return findWays(arr, (totSum - d) / 2);
	}

	public static void main(String[] args) {
		int[] arr = { 5, 2, 5, 1 };
		int k = 3;
		int n = arr.length;
		int res = countPartitions(n, k, arr);
		System.out.println(res);
	}
}
