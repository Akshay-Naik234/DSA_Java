package com.akshay.subsequnce;

import java.util.*;

public class LeetCode_17 {
	public static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (digits == null || digits.length() == 0) {
			return result;
		}

		String[] mappings = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		letterCombinationsRecursive(result, digits, "", 0, mappings);
		return result;
	}

	private static void letterCombinationsRecursive(List<String> result, String digits, String current, int index, String[] mappings) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        
        String letters = mappings[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            letterCombinationsRecursive(result, digits, current + letters.charAt(i), index + 1, mappings);
        }
	}
	
	public static void main(String[] args) {
		String digits = "23";
		List<String> res = letterCombinations(digits);
		System.out.println(res);
	}
}
