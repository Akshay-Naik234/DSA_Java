package com.akshay.graph.topoSort;

import java.util.*;

public class Kahns_Algo {
	public static List<Integer> topologicalSort(int[][] edges, int e, int v) {

		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		for (int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
		}
		
		int[] indegree = new int[v];
		Queue<Integer> q = new LinkedList<>();
		List<Integer> res = new ArrayList<>();
		for(int i=0;i<v;i++) {
			for(int in : adj.get(i)) {
				indegree[in]++;
			}
		}
		for(int i=0;i<v;i++) {
			if(indegree[i] ==0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			Integer peek = q.peek();
			res.add(peek);
			q.remove();
			for(int it:adj.get(peek)) {
				indegree[it]--;
				if(indegree[it]==0) {
					q.add(it);
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[][] edges = { { 0, 2 }, { 1, 2 }, { 3, 1 }, { 0, 4 } };
		List<Integer> res = topologicalSort(edges, 4, 5);
		for (int node : res) {
			System.out.print(node + " ");
		}
		System.out.println("");
	}
}
