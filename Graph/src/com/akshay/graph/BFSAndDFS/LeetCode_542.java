package com.akshay.graph.BFSAndDFS;

import java.util.*;

public class LeetCode_542 {
	static class Pair {
		int row;
		int col;
		int dist;

		Pair(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
	}

	public static int[][] updateMatrix(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;
		int[][] visited = new int[n][m];
		int[][] res = new int[n][m];
		Queue<Pair> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (mat[i][j] == 0) {
					visited[i][j] = 1;
					res[i][j] = 1;
					q.add(new Pair(i, j, 0));
				}
			}
		}
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		while (!q.isEmpty()) {
			int row = q.peek().row;
			int col = q.peek().col;
			int step = q.peek().dist;
			res[row][col] = step;
			q.remove();
			for (int i = 0; i < 4; i++) {
				int nrow = row + dr[i];
				int ncol = col + dc[i];
				if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0) {
					q.add(new Pair(nrow, ncol, step + 1));
					visited[nrow][ncol] = 1;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 1, 0 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 } };

		int[][] ans = updateMatrix(grid);
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
}
