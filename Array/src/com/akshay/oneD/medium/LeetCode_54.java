package com.akshay.oneD.medium;

import java.util.*;

public class LeetCode_54 {
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		int rowLength = matrix.length;
		int colLength = matrix[0].length;
		int left = 0, top = 0;
		int right = colLength - 1;
		int bottom = rowLength - 1;

		while (left <= right && top <= bottom) {
			for (int i = left; i <= right; i++) {
				res.add(matrix[top][i]);
			}
			top++;
			for (int i = top; i <= bottom; i++) {
				res.add(matrix[i][right]);
			}
			right--;
			if (top <= bottom) {
				for (int i = right; i >= left; i--) {
					res.add(matrix[bottom][i]);
				}
				bottom--;
			}

			if (left <= right) {
				for (int i = bottom; i >= top; i--) {
					res.add(matrix[i][left]);
				}
				left++;
			}
		}
		return res;

	}
	
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		List<Integer> spiralOrder = spiralOrder(matrix);
		for (Integer i : spiralOrder) {
			System.out.print(i + " ");
		}
	}
}
