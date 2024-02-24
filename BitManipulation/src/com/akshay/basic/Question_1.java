package com.akshay.basic;

// https://www.codingninjas.com/studio/problems/bit-manipulation_8142533?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf
public class Question_1 {
	public static int[] bitManipulation(int num, int i) {
		int[] res = new int[3];
		res[0] = (num & (1 << (i - 1))) > 0 ? 1 : 0;
		res[1] = num | (1 << (i - 1));
		res[2] = num & ~(1 << (i - 1));
		return res;
	}

	public static void main(String[] args) {
		int[] bitManipulation = bitManipulation(25, 3);
		System.out.println(bitManipulation[0] + " " + bitManipulation[1] + " " + bitManipulation[2]);
	}
}
