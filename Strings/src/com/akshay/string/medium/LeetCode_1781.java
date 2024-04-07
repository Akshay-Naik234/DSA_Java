package com.akshay.string.medium;

public class LeetCode_1781 {

	public static int beautySum(String s) {
		int sum = 0;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			int[] count = new int[26];
			for (int j = i; j < n; j++) {
				count[s.charAt(j) - 'a']++;
				int minFreq = Integer.MAX_VALUE;
				int maxFreq = 0;
				for (int f : count) {
					if(f>0) {
						minFreq = Math.min(minFreq, f);
						maxFreq = Math.max(maxFreq, f);
					}
				}
				sum += maxFreq - minFreq;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		String s = "aabcb";
		int beautySum = beautySum(s);
		System.out.println(beautySum);
	}
}
