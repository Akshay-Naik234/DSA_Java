package com.akshay.interview;

public class XORFromLtoR {
	public static int findXOR(int L, int R) {
		return calculateXORUtil(R) ^ calculateXORUtil(L - 1);
	}

	public static int calculateXORUtil(int n) {
		switch (n % 4) {
		case 0:
			return n;
		case 1:
			return 1;
		case 2:
			return n + 1;
		case 3:
			return 0;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(findXOR(1, 5));
	}
}
