package com.akshay.oneD.easy;

public class ArraySortedCheck {
	public static int isSorted(int n, int[] a) {
		for (int i = 1; i < n; i++) {
			if (a[i] < a[i - 1]) {
				return 0;
			}
		}
		return 1;
	}
	public static void main(String[] args) {
		int a[] = {1,2,3,6,5};
		System.out.println(isSorted(a.length,a));
	}
}
