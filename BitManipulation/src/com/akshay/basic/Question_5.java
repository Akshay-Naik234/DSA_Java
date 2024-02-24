package com.akshay.basic;

public class Question_5 {
	public static int countSetBits(int n) {
		int cnt = 0;
		while (n > 0) {
			if ((n & 1) > 0) {
				cnt++;
			}
			n = n >> 1;
		}
		return cnt;
	}

	public static void main(String[] args) {
		int cnt = 0;
		for (int i = 1; i <= 7; i++) {
			cnt += countSetBits(i);
		}
		System.out.println(cnt);
	}
}
