package com.akshay.advancedMaths;

public class PowerN {
	public static double power(double N, int R) {
		
		if (R == 0 || N==1) {
			return 1;
		}
		
		double pow = Math.pow(2, 31);
		System.out.println(Math.pow(-5, 2));
		if(!(pow > R && -(pow) < R)) {
			return 0;
		}
	
		double sum = 1;
		if (R < 0) {
			for (int i = 0; i < R *-1; i++) {
				sum = sum / N;
				if(sum == 0) {
					return 0;
				}
				if (sum < (Math.pow(10,4) *-1)) {
					return 0;
				}
			}
		} else {
			for (int i = 0; i < R; i++) {
				sum = sum * N;
				if(sum == 0) {
					return 0;
				}
				if (sum > Math.pow(10,4)) {
					return 0;
				}
			}
		}

		return sum;
	}
	public static void main(String[] args) {
		double power = power(-1.00000,2147483647);
		System.out.println(power);
	}
}
