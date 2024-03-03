package com.akshay.graph.BFSAndDFS;

import java.util.*;

public class LeetCode_547 {
	public static int findCircleNum(int[][] isConnected) {
		int n = isConnected.length;
		ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjacencyList.add(new ArrayList<Integer>());
		}
		int m = isConnected[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (isConnected[i][j] == 1) {
					adjacencyList.get(i).add(j);
				}
			}
		}
		int[] visited = new int[n];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				cnt++;
				dfs(i, adjacencyList, visited);
			}

		}
		return cnt;
	}

	private static void dfs(int start, ArrayList<ArrayList<Integer>> adjacencyList, int[] visited) {
		visited[start] = 1;
		for (Integer it : adjacencyList.get(start)) {
			if (visited[it] == 0) {
				dfs(it, adjacencyList, visited);
			}
		}
	}

	public static void main(String[] args) {
		int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		int res = findCircleNum(isConnected);
		System.out.println(res);
	}
}
