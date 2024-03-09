package com.akshay.interview;

public class LeetCode_2220 {
	public static int minBitFlips(int start, int goal) {
		int cnt = 0;
		while (goal > 0 || start > 0) {
			if ((start & 1) != (goal & 1)) {
				cnt++;
			}
			start = start >> 1;
			goal = goal >> 1;
		}
		return cnt;
	}

	public static void main(String[] args) {
		int minBitFlips = minBitFlips(10, 7);
		System.out.println(minBitFlips);
	}
}
