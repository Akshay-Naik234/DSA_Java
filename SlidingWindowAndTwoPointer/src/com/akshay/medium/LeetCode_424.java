package com.akshay.medium;

import java.util.*;

public class LeetCode_424 {
	public static int characterReplacement(String s, int k) {
		int maxLength = 0;
		int start = 0;
		int maxCount = 0;
		Map<Character, Integer> charFreqMap = new HashMap<>();
		for (int end = 0; end < s.length(); end++) {
			charFreqMap.put(s.charAt(end), charFreqMap.getOrDefault(s.charAt(end), 0) + 1);
			maxCount = Math.max(maxCount, charFreqMap.get(s.charAt(end)));

			if (end - start + 1 - maxCount > k) {
				charFreqMap.put(s.charAt(start), charFreqMap.get(s.charAt(start)) - 1);
				start++;
			}

			maxLength = Math.max(maxLength, end - start + 1);
		}
		return maxLength;
	}
	
	public static void main(String[] args) {
		int res = characterReplacement("ABAB", 2);
		System.out.println(res);
		
	}
}
