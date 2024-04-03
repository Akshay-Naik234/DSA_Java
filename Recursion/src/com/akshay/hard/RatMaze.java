package com.akshay.hard;

import java.util.*;

public class RatMaze {
	public static List<String> ratMaze(int[][] mat) {
		List<String> res = new ArrayList<>();
		int m = mat.length;
		int n = mat[0].length;
		int[][] visited = new int[m][n];
		ratMazePath(0, 0, mat, visited, "", res, m, n);
		return res;
	}

	public static void ratMazePath(int i, int j, int[][] mat, int[][] visited, String move, List<String> res, int m,
			int n) {
		if (i == m - 1 && j == n - 1) {
			res.add(move);
			return;
		}

		// DownWards
		if (i + 1 < m && mat[i + 1][j] == 1 && visited[i + 1][j] == 0) {
			visited[i][j] = 1;
			ratMazePath(i + 1, j, mat, visited, move + 'D', res, m, n);
			visited[i][j] = 0;
		}

		// left
		if (j - 1 >= 0 && mat[i][j - 1] == 1 && visited[i][j - 1] == 0) {
			visited[i][j] = 1;
			ratMazePath(i, j - 1, mat, visited, move + 'L', res, m, n);
			visited[i][j] = 0;
		}

		// right
		if (j + 1 < n && mat[i][j + 1] == 1 && visited[i][j + 1] == 0) {
			visited[i][j] = 1;
			ratMazePath(i, j + 1, mat, visited, move + 'R', res, m, n);
			visited[i][j] = 0;
		}

		// UPWards
		if (i - 1 >= 0 && mat[i - 1][j] == 1 && visited[i - 1][j] == 0) {
			visited[i][j] = 1;
			ratMazePath(i - 1, j, mat, visited, move + 'U', res, m, n);
			visited[i][j] = 0;
		}
	}
	
	public static void main(String[] args) {
		int[][] mat = {{1, 0, 0, 0},
			     {1, 1, 0, 1}, 
			     {1, 1, 0, 0},
			     {0, 1, 1, 1}};
		List<String> res = ratMaze(mat);
		System.out.println(res);
	}
}
