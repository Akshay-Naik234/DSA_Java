package com.akshay.graph.ShortestPath.algo;

import java.util.*;

public class LeetCode_1631 {
	static class tuple {
		int first;
		int second;
		int third;

		public tuple(int first, int second, int third) {
			this.first = first;
			this.second = second;
			this.third = third;
		}
	}

	public static int minimumEffortPath(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[][] dist = new int[n][m];
		for (int[] d : dist) {
			Arrays.fill(d, (int) 1e9);
		}
		dist[0][0] = 0;
		PriorityQueue<tuple> q = new PriorityQueue<tuple>((x, y) -> x.first - y.first);
		q.add(new tuple(0, 0, 0));
		while (!q.isEmpty()) {
			int dis = q.peek().first;
			int row = q.peek().second;
			int col = q.peek().third;
			q.remove();

			if (row == n - 1 && col == m - 1) {
				return dis;
			}
			int[] dr = { 0, -1, 1, 0 };
			int[] dc = { -1, 0, 0, 1 };
			for (int i = 0; i < 4; i++) {
				int nrow = row + dr[i];
				int ncol = col + dc[i];
				if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
					int newEffort = Math.max(Math.abs(grid[row][col] - grid[nrow][ncol]), dis);
					if (newEffort < dist[nrow][ncol]) {
						dist[nrow][ncol] = newEffort;
						q.add(new tuple(newEffort, nrow, ncol));
					}

				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[][] grid = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };
		int res = minimumEffortPath(grid);
		System.out.println(res);
	}
}
