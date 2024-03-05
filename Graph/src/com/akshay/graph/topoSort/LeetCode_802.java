package com.akshay.graph.topoSort;

import java.util.*;

public class LeetCode_802 {
	public static List<Integer> findSafeNodes(int v, ArrayList<ArrayList<Integer>> adj) {
		int[] inDegree = new int[v];
		Queue<Integer> q = new LinkedList<>();
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < v; i++) {
			for (int it : adj.get(i)) {
				inDegree[it]++;
			}
		}

		for (int i = 0; i < v; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int peek = q.peek();
			q.remove();
			res.add(peek);
			for (int it : adj.get(peek)) {
				inDegree[it]--;
				if (inDegree[it] == 0) {
					q.add(it);
				}
			}
		}
		Collections.sort(res);
		return res;

	}

	public static List<Integer> eventualSafeNodes(int[][] graph) {
		int v = graph.length;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < v; i++) {
			for (int j : graph[i]) {
				adj.get(j).add(i);
			}
		}
		return findSafeNodes(v, adj);
	}
	
	public static void main(String[] args) {
		int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
		List<Integer> res = eventualSafeNodes(graph);
		System.out.println(res);
	}
}
