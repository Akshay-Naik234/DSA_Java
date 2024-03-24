package com.akshay.greedy.easy;

import java.util.*;

public class LeetCode_678 {
	public static boolean checkValidString(String s) {
		Stack<Integer> openStack = new Stack<>();
		Stack<Integer> starStack = new Stack<>();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '(') {
				openStack.push(i);
			} else if (s.charAt(i) == '*') {
				starStack.push(i);
			} else {
				if (!openStack.isEmpty()) {
					openStack.pop();
				} else if (!starStack.isEmpty()) {
					if (i > starStack.peek()) {
						starStack.pop();
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		}
		while (!openStack.isEmpty()) {
			if (starStack.isEmpty()) {
				return false;
			}
			if (starStack.peek() > openStack.peek()) {
				openStack.pop();
				starStack.pop();
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(checkValidString("(*))"));
	}
}
