package com.akshay.subsequnce;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_22 {
	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		generateParenthesisHelper(n, 0, 0, "", res);
		return res;
	}

	private static void generateParenthesisHelper(int n, int openCount, int closeCount, String current,
			List<String> res) {
		if (current.length() == 2 * n) {
			res.add(current);
			return;
		}
		if (openCount < n) {
			generateParenthesisHelper(n, openCount + 1, closeCount, current + "(", res);
		}
		if (closeCount < openCount) {
			generateParenthesisHelper(n, openCount, closeCount + 1, current + ")", res);
		}
	}

	public static void main(String[] args) {
		List<String> res = generateParenthesis(3);
		System.out.println(res);
	}
}
