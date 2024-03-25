package com.akshay.greedy.medium;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode_435 {
	public static int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, new Comparator<>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		int end = intervals[0][1];
		int ans = 0;
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < end) {
				ans++;
			} else {
				end = intervals[i][1];
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
		System.out.println(eraseOverlapIntervals(intervals));
	}
}
