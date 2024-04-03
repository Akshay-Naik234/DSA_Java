package com.akshay.hard;

import java.util.*;

public class LeetCode_51 {
	public static List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		List<List<String>> res = new ArrayList<>();
		dfs(0, board, res);
		return res;
	}

	private static void dfs(int col, char[][] board, List<List<String>> res) {
		if (col == board.length) {
			res.add(construct(board));
			return;
		}
		for (int row = 0; row < board.length; row++) {
			if (isValid(board, row, col)) {
				board[row][col] = 'Q';
				dfs(col + 1, board, res);
				board[row][col] = '.';
			}
		}

	}

	private static boolean isValid(char[][] board, int row, int col) {
		int dupRow = row;
		int dupCol = col;
		while (row >= 0 && col >= 0) {
			if (board[row][col] == 'Q') {
				return false;
			}
			row--;
			col--;
		}
		row = dupRow;
		col = dupCol;
		while (col >= 0) {
			if (board[row][col] == 'Q') {
				return false;
			}
			col--;
		}

		row = dupRow;
		col = dupCol;
		while (row < board.length && col >= 0) {
			if (board[row][col] == 'Q') {
				return false;
			}
			row++;
			col--;
		}
		return true;
	}

	private static List<String> construct(char[][] board) {
		int n = board.length;
		List<String> path = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String s = new String(board[i]);
			path.add(s);
		}
		return path;
	}

	public static void main(String[] args) {
		List<List<String>> res = solveNQueens(4);
		System.out.println(res);
	}

}
