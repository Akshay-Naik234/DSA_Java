package com.akshay.advancedMaths;

public class LeetCode_50 {
	public static double myPow(double x, int n) {
		double result = 1.0;
		long power = Math.abs((long) n);
		while(power>0) {
			if((power & 1) == 1) {
				result*=x;
				power=power-1;
			}
			else {
				x=x*x;
				power = power>>1;
			}
		}
		return n<0 ? 1/result:result;
	}
	public static void main(String[] args) {
		double myPow = myPow(2.10000, 3);
		System.out.println(myPow);
	}
}
