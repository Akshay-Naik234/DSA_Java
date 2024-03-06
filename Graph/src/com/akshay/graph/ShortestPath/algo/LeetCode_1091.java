package com.akshay.graph.ShortestPath.algo;

import java.util.*;

public class LeetCode_1091 {

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

	public static int shortestPathBinaryMatrix(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[][] dist = new int[n][m];
		for (int[] d : dist) {
			Arrays.fill(d, (int) 1e9);
		}
		Queue<tuple> q = new LinkedList<>();
		if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
			return -1;
		}
		if (n == 1 && m == 1 && grid[0][0] == 0) {
			return 1;
		}
		q.add(new tuple(1, 0, 0));
		while (!q.isEmpty()) {
			int dis = q.peek().first;
			int row = q.peek().second;
			int col = q.peek().third;
			q.remove();
			int[] dr = { 0, -1, 1, 0, -1, 1, -1, 1 };
			int[] dc = { -1, 0, 0, 1, 1, 1, -1, -1 };
			for (int i = 0; i < 8; i++) {
				int nrow = row + dr[i];
				int ncol = col + dc[i];
				if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 0
						&& dis + 1 < dist[nrow][ncol]) {
					if (nrow == n - 1 && ncol == m - 1) {
						return dis + 1;
					}
					dist[nrow][ncol] = dis + 1;
					q.add(new tuple(dis + 1, nrow, ncol));
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
		int res = shortestPathBinaryMatrix(grid);
		System.out.println(res);
	}
}
