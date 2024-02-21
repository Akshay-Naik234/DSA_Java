package com.akshay.oneD.medium;

public class LeetCode_48 {

	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < m; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = matrix[i][n - j - 1];
				matrix[i][n - j - 1] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(matrix);
		for (int[] is : matrix) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
