package com.akshay.stack.imp;

import java.util.Stack;

public class LeetCode_907 {
	public static int sumSubarrayMins(int[] arr) {
		final int MOD = 1_000_000_007;
		int n = arr.length;
		long ans = 0;
		Stack<Integer> stack = new Stack<>();
		int[] prevSmaller = new int[n];
		int[] nextSmaller = new int[n];

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
			ans += (long) arr[i] * (i - prevSmaller[i]) * (nextSmaller[i] - i);
			ans %= MOD;
		}

		return (int) ans;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 1, 2, 4 };
		int sumSubarrayMins = sumSubarrayMins(arr);
		System.out.println(sumSubarrayMins);
	}
}
