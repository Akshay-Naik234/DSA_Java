package com.akshay.greedy.medium;

import java.util.*;

public class LeetCode_57 {
	public static int[][] insert(int[][] intervals, int[] newInterval) {
		boolean checked = false;
		List<int[]> list = new ArrayList<>();
		for (int[] i : intervals) {
			if (i[0] > newInterval[0] && !checked) {
				list.add(newInterval);
				checked = true;
			}
			list.add(i);
		}
		if (list.size() == intervals.length) {
			list.add(newInterval);
		}
		return merge(list);
	}

	public static int[][] merge(List<int[]> list) {
		List<int[]> res = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {

			if (res.size() == 0 || list.get(i)[0] > res.get(res.size() - 1)[1]) {
				int[] temp = { list.get(i)[0], list.get(i)[1] };
				res.add(temp);
			} else if (list.get(i)[0] <= res.get(res.size() - 1)[1]) {
				res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], list.get(i)[1]);
			}
		}
		int[][] ans = new int[res.size()][2];
		for (int i = 0; i < res.size(); i++) {
			ans[i][0] = res.get(i)[0];
			ans[i][1] = res.get(i)[1];
		}
		return ans;
	}

	public static void main(String[] args) {
		int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
		int[] newIntervals = { 4, 8 };
		int[][] res = insert(intervals, newIntervals);

		for (int[] is : res) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
