package com.akshay.graph.BFSAndDFS;

import java.util.*;

public class LeetCode_994 {
	static class Pair {
		int row;
		int col;
		int t;

		Pair(int row, int col, int t) {
			this.row = row;
			this.col = col;
			this.t = t;
		}
	}

	public static int orangesRotting(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[][] visited = new int[n][m];
		Queue<Pair> q = new LinkedList<>();
		int freshCnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 2) {
					q.add(new Pair(i, j, 0));
					visited[i][j] = 2;
				}
				if (grid[i][j] == 1) {
					freshCnt++;
				}
			}
		}

		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int tm = 0;
		int cnt = 0;
		while (!q.isEmpty()) {
			int r = q.peek().row;
			int c = q.peek().col;
			int t = q.peek().t;
			tm = Math.max(t, tm);
			q.remove();
			for (int i = 0; i < 4; i++) {
				int nrow = r + dr[i];
				int ncol = c + dc[i];
				if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0
						&& grid[nrow][ncol] == 1) {
					q.add(new Pair(nrow, ncol, t + 1));
					visited[nrow][ncol] = 2;
					cnt++;
				}
			}
		}
		if (cnt != freshCnt) {
			return -1;
		}
		return tm;
	}
	
	public static void main(String[] args) {
		int[][] oranges = {{2,1,1},{1,1,0},{0,1,1}};
		int res = orangesRotting(oranges);
		System.out.println(res);
	}
}
