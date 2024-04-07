package com.akshay.string.medium;

public class LeetCode_5 {
	public static String longestPalindrome(String s) {
		int n = s.length();
		if(n<=1) {
			return s;
		}
		String LPS ="";
		for(int i=1;i<n;i++) {
			LPS = helper(i, i, s, LPS);
			LPS = helper(i-1, i, s, LPS);
		}
		return LPS;
	}
	
	public static String helper(int low,int high,String s,String LPS) {
		while(s.charAt(low) == s.charAt(high)) {
			low--;
			high++;
			if(low==-1 || high==s.length()) {
				break;
			}
		}
		String palindrome = s.substring(low+1,high);
		if(palindrome.length()>LPS.length()) {
			LPS = palindrome;
		}
		return LPS;
	}

	public static void main(String[] args) {
		String res = longestPalindrome("babad");
		System.out.println(res);
	}

}
