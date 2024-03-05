package com.akshay.graph.ShortestPath.algo;

import java.util.*;

public class ShortestPathUAG {
	public static int[] shortestPath(int n, int[][] edges, int src) {
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<Integer>());
		}
		for (int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		int[] dist = new int[n];
		for (int i = 0; i < n; i++) {
			dist[i] = (int) 1e9;
		}
		dist[src] = 0;
		while (!q.isEmpty()) {
			int node = q.peek();
			q.remove();
			for (int it : adj.get(node)) {
				if (dist[node] + 1 < dist[it]) {
					dist[it] = dist[node] + 1;
					q.add(it);
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (dist[i] == 1e9) {
				dist[i] = -1;
			}
		}
		return dist;
	}

	public static void main(String[] args) {
		int[][] edges = { { 0, 1 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 3, 4 } };
		int[] res = shortestPath(5, edges, 1);
		for (int result : res) {
			System.out.print(result + " ");
		}
	}
}
