package com.akshay.interview;

public class TwoNumbersWithOddOccurence {
	public static int[] twoOddNum(int[] arr) {
		int evenOdd = 0;
		int[] res = new int[2];
		for (int i = 0; i < arr.length; i++) {
			evenOdd = evenOdd ^ arr[i];
		}
		int xor = evenOdd;
		int pos = 0;
		while (evenOdd > 0) {
			if ((evenOdd & 1) > 0) {
				pos++;
				break;
			}
			pos++;
			evenOdd = evenOdd >> 1;
		}
		int first = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((((arr[i] >> (pos - 1)) & 1) > 0)) {
				first = first ^ arr[i];
			}
		}
		int second = xor ^ first;
		if (second > first) {
			res[0] = second;
			res[1] = first;
		} else {
			res[1] = second;
			res[0] = first;
		}

		return res;
	}

	public static void main(String[] args) {
		int[] twoOddNum = { 3, 3, 1, 2 };
		int[] twoOddNum2 = twoOddNum(twoOddNum);
		System.out.println(twoOddNum2[0] + " " + twoOddNum2[1]);
	}
}
