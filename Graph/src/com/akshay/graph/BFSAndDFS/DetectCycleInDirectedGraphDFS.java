package com.akshay.graph.BFSAndDFS;

import java.util.*;

public class DetectCycleInDirectedGraphDFS {
	public static Boolean isCyclic(int[][] edges, int v, int e) {
		int[] visited = new int[v];
		int[] pathVisited = new int[v];

		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		for (int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
		}

		for (int i = 0; i < v; i++) {
			if (visited[i] == 0) {
				if (dfs(i, adj, visited, pathVisited) == true) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean dfs(int i, List<List<Integer>> adj, int[] visited, int[] pathVisited) {
		visited[i] = 1;
		pathVisited[i] = 1;
		for (int it : adj.get(i)) {
			if (visited[it] == 0) {
				if (dfs(it, adj, visited, pathVisited) == true) {
					return true;
				}
			} else if (pathVisited[it] == 1) {
				return true;
			}
		}
		pathVisited[i] = 0;
		return false;
	}

	public static void main(String[] args) {
		int V = 4;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } };
		int[][] edge1 = { { 1, 0 }, { 1, 2 }, { 0, 2 } };
		Boolean res = isCyclic(edges, 4, 5);
		System.out.println(res);

	}
}
