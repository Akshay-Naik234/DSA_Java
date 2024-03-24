package com.akshay.medium;

import java.util.HashMap;

public class LeetCode_3 {
	
	public static int lengthOfLongestSubstring(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		int left = 0;
		int right = 0;
		int length = s.length();
		int ans = 0;
		while(right<length) {
			if(map.containsKey(s.charAt(right))) {
				left = Math.max(map.get(s.charAt(right))+1, left);
			}
			map.put(s.charAt(right),right);
			ans = Math.max(ans, right-left+1);
			right++;
		}
		return ans;
	}
	public static void main(String[] args) {
		String s = "abcabcbb";
		int res = lengthOfLongestSubstring(s);
		System.out.println(res);
	}
}
