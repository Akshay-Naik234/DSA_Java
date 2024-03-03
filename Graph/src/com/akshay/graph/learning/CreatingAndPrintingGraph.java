package com.akshay.graph.learning;

import java.util.ArrayList;
import java.util.List;

public class CreatingAndPrintingGraph {

	public static void main(String[] args) {		
		int[][] edges = { { 1, 2 }, { 0,3 }, { 2,3 } };
		int n = 4;
		ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjacencyList.add(new ArrayList<Integer>());
		}
		for (int[] a : edges) {
			if(a[0] == a[1]) {
				continue;
			}
			adjacencyList.get(a[0]).add(a[1]);
			adjacencyList.get(a[1]).add(a[0]);
		}
		int i=0;
		for (ArrayList<Integer> arrayList : adjacencyList) {
			System.out.print(i++ +" ");
			for (Integer num : arrayList) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
}
//0 1 2
//1 0 2
//2 0 1