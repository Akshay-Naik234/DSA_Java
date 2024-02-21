package com.akshay.oneD.hard;

import java.util.*;

public class LeetCode_56 {
	public static int[][] merge(int[][] intervals) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});

		int n = intervals.length;
		for (int i = 0; i < n; i++) {
			if (res.size() == 0 || res.get(res.size() - 1).get(1) < intervals[i][0]) {
				res.add(Arrays.asList(intervals[i][0], intervals[i][1]));
			} else if (res.get(res.size() - 1).get(1) >= intervals[i][0]) {
				res.get(res.size() - 1).set(1, Math.max(res.get(res.size() - 1).get(1), intervals[i][1]));
			}
		}
		int[][] res1 = new int[res.size()][2];
		for (int i = 0; i < res.size(); i++) {
			res1[i][0] = res.get(i).get(0);
			res1[i][1] = res.get(i).get(1);
		}
		return res1;
	}
	
	public static void main(String[] args) {
		int[][] a = {{1,3},{2,6},{8,10},{15,18}};
		int[][] merge = merge(a);
		for (int[] i : merge) {
			for(int j:i) {
				System.out.print( j + " ");
			}
			System.out.println();
		}
	}
}
