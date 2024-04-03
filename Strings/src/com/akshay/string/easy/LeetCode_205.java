package com.akshay.string.easy;

import java.util.*;

public class LeetCode_205 {
	public static boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> map = new HashMap<>();
		if (s.length() != t.length()) {
			return false;
		}
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			char b = t.charAt(i);
			if (map.containsKey(a)) {
				if (!map.get(a).equals(b)) {
					return false;
				}
			} else {
				if (map.containsValue(b)) {
					return false;
				} else {
					map.put(a, b);
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		boolean res = isIsomorphic("egg","add");
		System.out.println(res);
	}
}
