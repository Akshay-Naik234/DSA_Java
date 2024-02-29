package com.akshay.stack.imp;

import java.util.*;

public class LeetCode_84 {
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

	public static void main(String[] args) {
		int[] heights = { 2, 1, 5, 6, 2, 3 };
		System.out.println(largestRectangleArea(heights));
	}
}
