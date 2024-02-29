package com.akshay.stack.basic;

import java.util.Stack;

public class LeetCode_20 {
	public static boolean isValid(String s) {

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if ((s.charAt(i) == '(') || (s.charAt(i) == '{') || (s.charAt(i) == '[')) {
				stack.push(s.charAt(i));
			} else if ((s.charAt(i) == ')') || (s.charAt(i) == '}') || (s.charAt(i) == ']')) {
				if (stack.isEmpty()) {
					return false;
				}
				if (s.charAt(i) == ')' && stack.peek() == '(') {
					stack.pop();
				} else if (s.charAt(i) == '}' && stack.peek() == '{') {
					stack.pop();
				} else if (s.charAt(i) == ']' && stack.peek() == '[') {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		if (stack.isEmpty()) {
			return true;
		}
		return false;

	}

	public static void main(String[] args) {
		boolean valid = isValid("()[]{}");
		System.out.println(valid);
	}
}
