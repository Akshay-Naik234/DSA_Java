package com.akshay.dp.string;

public class PrintLongestCommonSubsequence {

	public static String f(int n, int m, String s1, String s2, String res) {
		if (n < 0 || m < 0) {
			return res;
		}
		if (s1.charAt(n) == s2.charAt(m)) {
			return res + f(n - 1, m - 1, s1, s2, res + s1.charAt(n));
		}

		String a = f(n - 1, m, s1, s2, res);
		String b = f(n, m - 1, s1, s2, res);
		System.out.println(a);
		System.out.println(b);
		System.out.println("*******************");
		return res;
	}

	public static String findLCS(int n, int m, String s1, String s2) {
		return f(n, m, s1, s2, "");
	}

	public static void main(String[] args) {
		String s1 = "ababa";
		String s2 = "cbbcad";
		int n = s1.length();
		int m = s2.length();
		String res = findLCS(n-1, m-1, s1, s2);
		System.out.println(res);

	}
}
