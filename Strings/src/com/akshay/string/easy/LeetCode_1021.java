package com.akshay.string.easy;

import java.util.*;

public class LeetCode_1021 {
	public static String removeOuterParentheses(String s) {
		StringBuilder res = new StringBuilder();
		Stack<Character> stack = new Stack<>();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '(') {
				if (stack.size() >= 1) {
					res.append(s.charAt(i));
				}
				stack.push(s.charAt(i));
			} else {
				if (stack.size() > 1) {
					res.append(s.charAt(i));
				}
				stack.pop();
			}
		}
		return res.toString();
	}
	
	public static void main(String[] args) {
		String s = "(()())(())";
	    System.out.println(removeOuterParentheses(s));
	}
}
