package com.akshay.TwoD;

public class LeetCode_74 {
	public static boolean searchMatrix(int[][] matrix, int target) {
		int n = matrix.length;
		int m = matrix[0].length;
		int low = 0;
		int high = n * m - 1;
		int row, col, mid;
		while (low <= high) {
			mid = (low + high) / 2;
			row = mid / m;
			col = mid % m;
			if (matrix[row][col] == target) {
				return true;
			} else if (matrix[row][col] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		int k = 3;
		System.out.println(searchMatrix(matrix, k));
	}
}
