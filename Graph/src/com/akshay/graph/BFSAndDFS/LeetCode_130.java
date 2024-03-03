package com.akshay.graph.BFSAndDFS;

public class LeetCode_130 {

	public static void solve(char[][] board) {
		int n = board.length;
		int m = board[0].length;
		int[][] visited = new int[n][m];

		for (int i = 0; i < m; i++) {
			if (visited[0][i] == 0 && board[0][i] == 'O') {
				dfs(0, i, board, visited, n, m);
			}
		}
		for (int i = 0; i < m; i++) {
			if (visited[n - 1][i] == 0 && board[n - 1][i] == 'O') {
				dfs(n - 1, i, board, visited, n, m);
			}
		}
		for (int i = 0; i < n; i++) {
			if (visited[i][0] == 0 && board[i][0] == 'O') {
				dfs(i, 0, board, visited, n, m);
			}
		}
		for (int i = 0; i < n; i++) {
			if (visited[i][m - 1] == 0 && board[i][m - 1] == 'O') {
				dfs(i, m - 1, board, visited, n, m);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] == 0 && board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
	}

	private static void dfs(int row, int col, char[][] board, int[][] visited, int n, int m) {
		visited[row][col] = 1;
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		for (int i = 0; i < 4; i++) {
			int nrow = row + dr[i];
			int ncol = col + dc[i];
			if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0
					&& board[nrow][ncol] == 'O') {
				dfs(nrow, ncol, board, visited, n, m);
			}
		}

	}

	public static void main(String[] args) {
		char mat[][] = { { 'X', 'X', 'X', 'X' }, 
						 { 'X', 'O', 'X', 'X' },
						 { 'X', 'O', 'O', 'X' },
						 { 'X', 'O', 'X', 'X' },
						 { 'X', 'X', 'O', 'O' } 
						};
		solve(mat);
		int n = mat.length;
		int m = mat[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
}
