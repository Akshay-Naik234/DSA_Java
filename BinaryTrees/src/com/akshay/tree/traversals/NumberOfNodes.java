package com.akshay.tree.traversals;

public class NumberOfNodes {
	public static int numberOfNodes(int N) {
		return (int) Math.pow(2, N - 1);
	}

	public static void main(String[] args) {
		int res = numberOfNodes(5);
		System.out.println(res);
	}
}
