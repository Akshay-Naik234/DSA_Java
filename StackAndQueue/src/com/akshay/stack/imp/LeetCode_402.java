package com.akshay.stack.imp;

import java.util.Stack;

public class LeetCode_402 {
	public static String removeKDigits(String num, int k) {
		if (k == num.length())
			return "0";

		Stack<Character> stack = new Stack<>();

		for (char digit : num.toCharArray()) {
			while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
				stack.pop();
				k--;
			}
			stack.push(digit);
		}

		// Handle the case when k > 0
		while (k > 0) {
			stack.pop();
			k--;
		}

		// Build the result string
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.insert(0, stack.pop());
		}

		// Remove leading zeros
		while (sb.length() > 1 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		String removeKDigits = removeKDigits("3021083557", 6);
		System.out.println(removeKDigits);
	}
}
