package com.akshay.graph.ShortestPath.algo;

import java.util.*;

public class BellmanFord {
	static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
		int[] dist = new int[V];
		for (int i = 0; i < V; i++) {
			dist[i] = (int) 1e8;
		}
		dist[S] = 0;
		for (int j = 0; j < V - 1; j++) {
			for (List<Integer> edge : edges) {
				int u = edge.get(0);
				int v = edge.get(1);
				int wt = edge.get(2);
				if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
					dist[v] = dist[u] + wt;
				}
			}
		}
		for (List<Integer> edge : edges) {
			int u = edge.get(0);
			int v = edge.get(1);
			int wt = edge.get(2);
			if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
				int[] temp = { -1 };
				return temp;
			}
		}
		return dist;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> edges = new ArrayList<>() {
			{
				add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
				add(new ArrayList<Integer>(Arrays.asList(1, 0, 3)));
				add(new ArrayList<Integer>(Arrays.asList(1, 2, -1)));
				add(new ArrayList<Integer>(Arrays.asList(2, 0, 1)));
			}
		};
		int[] res = bellman_ford(3, edges, 2);
		for (int i : res) {
			System.out.print(i + "  ");
		}
	}
}
