package com.akshay.graph.ShortestPath.algo;

import java.util.*;

public class ShortestPathDAG {
	static class Pair {
		int first;
		int second;

		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	public static int[] shortestPathInDAG(int n, int m, int[][] edges) {
		List<List<Pair>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<Pair>());
		}
		for (int[] edge : edges) {
			adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
		}
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, 0));
		int[] dist = new int[n];
		for (int i = 0; i < n; i++) {
			dist[i] = (int) 1e9;
		}
		dist[0] = 0;
		while (!q.isEmpty()) {
			int node = q.peek().first;
			q.remove();
			for (int k = 0; k < adj.get(node).size(); k++) {
				int it = adj.get(node).get(k).first;
				int weight = adj.get(node).get(k).second;
				if (dist[node] + weight < dist[it]) {
					dist[it] = dist[node] + weight;
					q.add(new Pair(it, dist[it]));
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
		int[][] edges = {{0, 1, 2}, {1, 2, 3}, {0, 2, 6}};
		int[] res = shortestPathInDAG(3, 3, edges);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}
}
