package com.akshay.advancedMaths;

import java.util.*;

public class AllDivisorsOfNumber {
	public static List<Integer> printDivisors(int n) {
		List<Integer> res = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				res.add(i);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		List<Integer> printDivisors = printDivisors(10);
		System.out.println(printDivisors);
	}
}
