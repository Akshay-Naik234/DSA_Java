package com.akshay.graph.BFSAndDFS;

import java.util.ArrayList;
import java.util.List;

public class CycleInUnDirectedGraphDFS {
	static boolean detectCycle(int V, List<List<Integer>> adj) {
		int[] visited = new int[V];
		for (int i = 0; i < V; i++) {
			if (visited[i] == 0 && detectCycleUsingDFS(i, adj, visited, -1) == true) {
				return true;
			}
		}
		return false;
	}

	private static boolean detectCycleUsingDFS(int i, List<List<Integer>> adj, int[] visited, int parent) {
		visited[i] = 1;
		for (int start : adj.get(i)) {
			if (visited[start] == 0) {
				if (detectCycleUsingDFS(start, adj, visited, i) == true) {
					return true;
				}
			} else if (parent != start) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(1).add(2);
		adj.get(2).add(1);
		adj.get(2).add(3);
		adj.get(3).add(2);

		boolean ans = detectCycle(4, adj);
		if (ans)
			System.out.println("1");
		else
			System.out.println("0");
	}
}
