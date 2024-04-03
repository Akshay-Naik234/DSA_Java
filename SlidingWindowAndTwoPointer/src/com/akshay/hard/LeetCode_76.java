package com.akshay.hard;

import java.util.*;

public class LeetCode_76 {
	public static String minWindow(String s, String t) {
		if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
			return "";
		}

		Map<Character, Integer> targetFreq = new HashMap<>();
		for (char c : t.toCharArray()) {
			targetFreq.put(c, targetFreq.getOrDefault(c, 0) + 1);
		}

		int requiredChars = targetFreq.size();
		int left = 0, right = 0;
		int minLen = Integer.MAX_VALUE;
		int minStart = 0;
		Map<Character, Integer> windowFreq = new HashMap<>();

		while (right < s.length()) {
			char currentChar = s.charAt(right);
			windowFreq.put(currentChar, windowFreq.getOrDefault(currentChar, 0) + 1);

			if (targetFreq.containsKey(currentChar)
					&& windowFreq.get(currentChar).intValue() == targetFreq.get(currentChar).intValue()) {
				requiredChars--;
			}

			while (requiredChars == 0) {
				if (right - left + 1 < minLen) {
					minLen = right - left + 1;
					minStart = left;
				}

				char leftChar = s.charAt(left);
				if (targetFreq.containsKey(leftChar)
						&& windowFreq.get(leftChar).intValue() == targetFreq.get(leftChar).intValue()) {
					requiredChars++;
				}
				windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
				left++;
			}

			right++;
		}

		return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);

	}
	
	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		String res = minWindow(s, t);
		System.out.println(res);
	}
}
