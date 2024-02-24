package com.akshay.basic;

public class Question_2 {
	static boolean isKthBitSet(int n, int k) {
		return ((n & (1 << (k - 1))) > 0) ? true : false;
	}

	public static void main(String[] args) {
		System.out.println(isKthBitSet(25, 4));
	}
}
