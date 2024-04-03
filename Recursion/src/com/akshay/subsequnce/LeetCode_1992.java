package com.akshay.subsequnce;

public class LeetCode_1992 {

	public static int countGoodNumbers(long n) {
		long mod = 1000000007;
		long evenDigits = (n+1)/2;
		long oddDigits = n/2;
		long evenCounts = pow(5,evenDigits);
		long oddCounts = pow(4,oddDigits);
		long res = (evenCounts*oddCounts)%mod;
		return (int) res;
	}
	
	private static long pow(long base,long exp) {
		long res = 1;
		long mod = 1000000007;
		while(exp>0) {
			if(exp%2 == 1) {
				res = (res * base)%mod;
			}
			base = (base * base)%mod;
			exp = exp /2;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int res = countGoodNumbers(20);
		System.out.println(res);
	}
	
}
