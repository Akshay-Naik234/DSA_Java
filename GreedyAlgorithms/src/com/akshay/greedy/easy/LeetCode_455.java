package com.akshay.greedy.easy;

import java.util.*;

public class LeetCode_455 {
	public static int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int ans = 0;
		int j = 0;
		for (int i : g) {
			while (j < s.length && s[j] < i) {
				j++;
			}
			if (j == s.length) {
				return ans;
			} else {
				ans++;
				j++;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] g = {1,2,3};
		int[] s = {1,1};
		int res = findContentChildren(g, s);
		System.out.println(res);
	}
}
