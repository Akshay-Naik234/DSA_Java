package com.akshay.stack.imp;

import java.util.Stack;

public class LeetCode_503 {
	public static int[] nextGreaterElements(int[] arr) {
		int n = arr.length;
		int[] resList = new int[arr.length];
		Stack<Integer> st = new Stack<>();
		st.push(arr[n - 1]);
		resList[n - 1] = -1;
		for (int i = 2*n - 2; i >= 0; i--) {
			while (!st.isEmpty() && st.peek() <= arr[i%n]) {
				st.pop();
			}
			if(i<n) {
				int res = st.isEmpty() ? -1 : st.peek();
				resList[i] = res;
			}
			
			st.push(arr[i%n]);
		}
		return resList;

	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,1};
		int[] res = nextGreaterElements(nums);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}
}
