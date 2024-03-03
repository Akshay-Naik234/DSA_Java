package com.akshay.graph.learning;

public class CountGraph {
	public static int countingGraphs(int N) {
		int total = (N*(N-1))/2;
		return 1 << total;
	}
	
	public static void main(String[] args) {
		System.out.println(countingGraphs(2));
	}
}
