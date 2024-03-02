package com.akshay.dp.MCM;

import java.util.*;

public class LeetCode_1547 {
	public static int minCost(int n, int[] cut) {
		int c = cut.length;
		List<Integer> cuts = new ArrayList<>();
		for (int i = 0; i < c; i++) {
			cuts.add(cut[i]);
		}
		int[][] dp = new int[c + 2][c + 2];
		cuts.add(0);
		cuts.add(n);
		Collections.sort(cuts);
		for (int i = c; i >= 1; i--) {
			for (int j = 1; j <= c; j++) {
				if (i > j)
					continue;

				int mini = Integer.MAX_VALUE;

				for (int ind = i; ind <= j; ind++) {
					int ans = cuts.get(j + 1) - cuts.get(i - 1) + dp[i][ind - 1] + dp[ind + 1][j];
					mini = Math.min(mini, ans);
				}

				dp[i][j] = mini;
			}
		}
		return dp[1][c];
	}

	public static void main(String[] args) {
		int[] cuts = { 1, 3, 4, 5 };
		int n = 7;
		int minCost = minCost(n, cuts);
		System.out.println(minCost);
	}
}
