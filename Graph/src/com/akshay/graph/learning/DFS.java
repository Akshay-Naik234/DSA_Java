package com.akshay.graph.learning;

import java.util.*;

public class DFS {
	public static List<Integer> depthFirstSearch(int v, ArrayList<ArrayList<Integer>> edges) {
		int[] visited = new int[v];
		List<Integer> res = new ArrayList<>();
		return dfs(edges, visited, 0, res);
	}

	private static List<Integer> dfs(ArrayList<ArrayList<Integer>> edges, int[] visited, int start, List<Integer> res) {
		visited[start] = 1;
		res.add(start);
		for (int i : edges.get(start)) {
			if (visited[i] == 0) {
				dfs(edges, visited, i, res);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(2);
		adj.get(2).add(0);
		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(0).add(3);
		adj.get(3).add(0);
		adj.get(2).add(4);
		adj.get(4).add(2);

		List<Integer> ans = depthFirstSearch(5, adj);
		int n = ans.size();
		for (int i = 0; i < n; i++) {
			System.out.print(ans.get(i) + " ");
		}
	}
}
