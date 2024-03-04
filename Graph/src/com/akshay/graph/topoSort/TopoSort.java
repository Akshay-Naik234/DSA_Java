package com.akshay.graph.topoSort;

import java.util.*;

public class TopoSort {

	public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
		int[] visited = new int[v];

		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
		for (int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
		}

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < v; i++) {
			if (visited[i] == 0) {
				dfs(i, adj, visited, stack);
			}
		}
		List<Integer> res = new ArrayList<>();
		while (!stack.isEmpty()) {
			res.add(stack.peek());
			stack.pop();
		}
		return res;
	}

	private static void dfs(int i, List<List<Integer>> adj, int[] visited, Stack<Integer> stack) {
		visited[i] = 1;
		for (int it : adj.get(i)) {
			if (visited[it] == 0) {
				dfs(it, adj, visited, stack);
			}
		}
		stack.push(i);
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
