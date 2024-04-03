package com.akshay.string.easy;

public class LeetCode_151 {
	public static String reverseWords(String s) {
		if (s.length() == 0 || s.trim().length() == 0) {
			return "";
		}
		StringBuilder reverseString = new StringBuilder();
		int end = s.length();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				end = i;
			} else if (i == 0 || s.charAt(i - 1) == ' ') {
				if (reverseString.length() != 0) {
					reverseString.append(' ');
				}
				reverseString.append(s.substring(i, end));
			}
		}
		return reverseString.toString();
	}

	public static void main(String[] args) {
		String reverseWords = reverseWords("a good   example");
		System.out.println(reverseWords);
	}
}
