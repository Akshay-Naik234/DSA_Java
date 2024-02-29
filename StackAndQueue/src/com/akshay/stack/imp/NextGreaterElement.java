package com.akshay.stack.imp;

import java.util.Stack;

public class NextGreaterElement {
	public static int[] nextGreaterElement(int[] arr, int n) {
		int[] resList = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		st.push(arr[n - 1]);
		resList[n - 1] = -1;
		for (int i = n - 2; i >= 0; i--) {
			while (!st.isEmpty() && st.peek() <= arr[i]) {
				st.pop();
			}
			int res = st.isEmpty() ? -1 : st.peek();
			resList[i] = res;
			st.push(arr[i]);
		}
		return resList;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 7, 12, 1, 20 };
		int[] res = nextGreaterElement(arr, 4);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}
}
