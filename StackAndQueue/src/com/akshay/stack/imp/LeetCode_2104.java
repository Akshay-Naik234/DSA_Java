package com.akshay.stack.imp;

import java.util.Stack;

public class LeetCode_2104 {
	
	//Same as leetcode 907 but prevGreater and nextGreater Added
	public long subArrayRanges(int[] arr) {
		int n = arr.length;
		long smaller = 0;
		long greater = 0;
		Stack<Integer> stack = new Stack<>();
		int[] prevSmaller = new int[n];
		int[] nextSmaller = new int[n];

		int[] prevGreater = new int[n];
		int[] nextGreater = new int[n];

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
				stack.pop();
			}
			prevSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(i);
		}

		stack.clear();
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
				stack.pop();
			}
			nextSmaller[i] = stack.isEmpty() ? n : stack.peek();
			stack.push(i);
		}
		for (int i = 0; i < n; i++) {
			smaller += (long) arr[i] * (i - prevSmaller[i]) * (nextSmaller[i] - i);
		}

		stack.clear();
		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
				stack.pop();
			}
			prevGreater[i] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(i);
		}

		stack.clear();
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
				stack.pop();
			}
			nextGreater[i] = stack.isEmpty() ? n : stack.peek();
			stack.push(i);
		}
		for (int i = 0; i < n; i++) {
			greater += (long) arr[i] * (i - prevGreater[i]) * (nextGreater[i] - i);
		}

		return greater - smaller;
	}
}
