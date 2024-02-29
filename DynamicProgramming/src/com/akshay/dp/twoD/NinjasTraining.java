package com.akshay.dp.twoD;

public class NinjasTraining {
	public static int f(int n, int[][] points, int[][] dp, int last) {
		if (dp[n][last] != -1) {
			return dp[n][last];
		}
		if (n == 0) {
			int maxi = 0;
			for (int i = 0; i < 3; i++) {
				if (i != last) {
					maxi = Math.max(maxi, points[0][i]);
				}
			}
			return dp[n][last] = maxi;
		}

		int maxi = 0;
		for (int i = 0; i < 3; i++) {
			if (i != last) {
				int activity = points[n][i] + f(n - 1, points, dp, i);
				maxi = Math.max(activity, maxi);
			}
		}
		return dp[n][last] = maxi;
	}
	
	
	public static int tabular(int n, int[][] points) {
		int[][] dp = new int[n][4];
		dp[0][0] = Math.max(dp[0][1], dp[0][2]);
		dp[0][1] = Math.max(dp[0][0], dp[0][2]);
		dp[0][2] = Math.max(dp[0][0], dp[0][1]);
		dp[0][3] = Math.max(dp[0][0], Math.max(dp[0][2],dp[0][1]));
		
		for(int i=1;i<n;i++) {
			for(int j = 0;j<4;j++) {
				dp[i] [j] = 0;
				for (int k = 0; k < 3; k++) {
					if (k != j) {
						int activity = points[i][k] + dp[i - 1][k];
						dp[i] [j] = Math.max(activity, dp[i] [j]);
					}
				}
			}
		}
		return dp[n-1][3];
	}

	public static int ninjaTraining(int n, int points[][]) {
		int[][] dp = new int[n][4];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
//		return tabular(n - 1, points, dp, 3);
		return 0;
	}
	
	public static void main(String[] args) {
		int[][] points = {{1,2,5}, {3 ,1 ,1} ,{3,3,3}};
		int n=3;
		int res = tabular(n, points);
		System.out.println(res);
	}

}
