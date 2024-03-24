package com.akshay.hard;

import java.util.*;

public class kDistinctChars {
	public static int kDistinctChar(int k, String s) {
		if (s == null || s.length() == 0 || k == 0) {
			return 0;
		}
		int start = 0;
		int res = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for (int end = 0; end < s.length(); end++) {
			char ch = s.charAt(end);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			while (map.size() > k) {
				char c = s.charAt(start);
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0) {
					map.remove(c);
				}
				start++;
			}
			res = Math.max(res, end - start + 1);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int res = kDistinctChar(2, "abbbbbbc");
		System.out.println(res);
	}
}
