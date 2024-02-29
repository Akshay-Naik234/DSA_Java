package com.akshay.stack.imp;

import java.util.*;

public class LeetCode_85 {
	public static int largestRectangleArea(int[] heights) {
		int maxi = 0;
		int n = heights.length;
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i <= n; i++) {
			while (!st.isEmpty() && (i == n || heights[st.peek()] >= heights[i])) {
				int height = heights[st.peek()];
				st.pop();
				int width;
				if (st.isEmpty()) {
					width = i;
				} else {
					width = i - st.peek() - 1;
				}
				maxi = Math.max(maxi, height * width);
			}
			st.push(i);
		}
		return maxi;
	}

	public static int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int m = matrix.length;
		int n = matrix[0].length;

		int[] heights = new int[n];
		int maxArea = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					heights[j] += 1;
				} else {
					heights[j] = 0;
				}
			}
			maxArea = Math.max(maxArea, largestRectangleArea(heights));
		}

		return maxArea;
	}

	public static void main(String[] args) {
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		int res = maximalRectangle(matrix);
		System.out.println(res);
	}
}
