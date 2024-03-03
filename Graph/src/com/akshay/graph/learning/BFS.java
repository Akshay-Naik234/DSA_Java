package com.akshay.graph.learning;

import java.util.*;

public class BFS {
	public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj) {
		int[] visited = new int[n];
		List<Integer> res = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		visited[0] = 1;
		while (!q.isEmpty()) {
			Integer poll = q.poll();
			res.add(poll);
			for (int i : adj.get(poll)) {
				if (visited[i] == 0) {
					q.add(i);
					visited[i] = 1;
				}
			}
		}
		return res;
	}

	public static void main(String args[]) {

		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(0).add(4);
		adj.get(4).add(0);
		adj.get(1).add(2);
		adj.get(2).add(1);
		adj.get(1).add(3);
		adj.get(3).add(1);

		List<Integer> ans = bfsTraversal(5, adj);
		int n = ans.size();
		for (int i = 0; i < n; i++) {
			System.out.print(ans.get(i) + " ");
		}
	}
}
