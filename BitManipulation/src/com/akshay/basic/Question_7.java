package com.akshay.basic;

public class Question_7 {
	public static void swapNumber(int[] a, int[] b) {
		a[0] = a[0] ^ b[0];
		b[0] = a[0] ^ b[0];
		a[0] = a[0] ^ b[0];
	}
	public static void main(String[] args) {
		int[] a = {5};
		int[] b = {7};
		swapNumber(a, b);
		System.out.println(a[0] + " "+b[0]);
	}
}
