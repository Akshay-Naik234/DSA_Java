package com.akshay.string.medium;

public class LeetCode_8 {
	public static int myAtoi(String str) {
		if (str == null || str.length() == 0)
			return 0;

		str = str.trim();
		if (str.length() == 0)
			return 0;

		int sign = 1;
		int index = 0;
		if (str.charAt(0) == '+' || str.charAt(0) == '-') {
			sign = str.charAt(0) == '-' ? -1 : 1;
			index++;
		}

		long result = 0;
		while (index < str.length() && Character.isDigit(str.charAt(index))) {
			result = result * 10 + (str.charAt(index) - '0');
			if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			index++;
		}

		return (int) result * sign;
	}
	
	public static void main(String[] args) {
		int res = myAtoi("4193 with words");
		System.out.println(res);
	}
}
