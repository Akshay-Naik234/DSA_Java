package com.akshay.advancedMaths;

public class LeetCode_204 {
	public static int countPrimes(int n) {
		boolean[] temp = new boolean[n];
		for (int i = 2; i < n; i++) {
			temp[i] = true;
		}
		for (int i = 2; i * i < n; i++) {
			if (!temp[i]) {
				continue;
			}
			for (int j = i * i; j < n; j += i) {
				temp[j] = false;
			}
		}
		int cnt = 0;
		for (int i = 2; i < n; i++) {
			if (temp[i]) {
				cnt++;
			}
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		int countPrimes = countPrimes(10);
		System.out.println(countPrimes);
	}
}
