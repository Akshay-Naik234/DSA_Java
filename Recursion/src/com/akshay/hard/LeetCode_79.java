package com.akshay.hard;

public class LeetCode_79 {
	public static boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || word == null || word.length() == 0) {
			return false;
		}
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dfs(board, word, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean dfs(char[][] board, String word, int row, int col, int ind) {
		if (ind == word.length()) {
			return true;
		}
		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length
				|| board[row][col] != word.charAt(ind)) {
			return false;
		}
		char temp = board[row][col];
		board[row][col] = '#';
		boolean found = dfs(board, word, row, col + 1, ind + 1) || dfs(board, word, row, col - 1, ind + 1)
				|| dfs(board, word, row + 1, col, ind + 1) || dfs(board, word, row - 1, col, ind + 1);
		board[row][col] = temp;
		return found;
	}

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word1 = "ABCCED";
		boolean res = exist(board, word1);
		System.out.println(res);
	}
}
