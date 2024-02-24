package com.akshay.basic;

public class Question_4 {
	public static boolean isPowerOfTwo(int n) {
		if (n <= 0) {
			return false;
		}
		return (n & (n - 1)) > 0 ? false : true;
	}
	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(4));
	}
}
