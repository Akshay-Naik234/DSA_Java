package com.akshay.graph.topoSort;

import java.util.*;

public class DetectCycleInDirectedBFS {
	public static boolean detectCycleInDirectedGraph(int v, ArrayList<ArrayList<Integer>> adj) {

		int[] indegree = new int[v];
		Queue<Integer> q = new LinkedList<>();
		int cnt = 0;
		for (int i = 0; i < v; i++) {
			for (int in : adj.get(i)) {
				indegree[in]++;
			}
		}
		for (int i = 0; i < v; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			Integer peek = q.peek();
			cnt++;
			q.remove();
			for (int it : adj.get(peek)) {
				indegree[it]--;
				if (indegree[it] == 0) {
					q.add(it);
				}
			}
		}
		return cnt != v;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		int[][] edges = { { 1, 2 }, { 4, 1 }, { 2, 4 }, { 3, 4 }, { 5, 2 }, { 1, 3 } };

		int[][] edges1 = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
		for (int i = 0; i <= 5; i++) {
			adj.add(new ArrayList<Integer>());
		}
		for (int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
		}
		System.out.println(adj);
		boolean res = detectCycleInDirectedGraph(5, adj);
		System.out.println(res);
	}
}
