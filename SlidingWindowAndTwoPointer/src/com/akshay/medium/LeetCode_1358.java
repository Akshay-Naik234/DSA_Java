package com.akshay.medium;

public class LeetCode_1358 {
	public static int numberOfSubstrings(String s) {
		int start = 0;
		int count = 0;
		int[] abc = new int[3];
		for (int end = 0; end < s.length(); end++) {
			abc[s.charAt(end) - 'a']++;
			while (abc[0] > 0 && abc[1] > 0 && abc[2] > 0) {
				abc[s.charAt(start) - 'a']--;
				start++;
				count += s.length() - end;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int res = numberOfSubstrings("abcabc");
		System.out.println(res);
	}
}
