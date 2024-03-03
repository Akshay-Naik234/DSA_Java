package com.akshay.graph.BFSAndDFS;

import java.util.*;

public class LeetCode_785 {

	public static boolean isBipartite(int[][] graph) {
		int n = graph.length;
		int[] color = new int[n];
		Arrays.fill(color, -1);
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int p = 0; p < n; p++) {
			adj.add(new ArrayList<Integer>());
		}
		int k = 0;
		for (int[] row : graph) {
			for (int value : row) {
				adj.get(k).add(value);
			}
			k++;
		}

		for (int i = 0; i < n; i++) {
			if (color[i] == -1) {
				
//				if (bfs(color, adj, i) == false) {
//					return false;
//				}
				if(dfs(0,color,adj,i)==false) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean bfs(int[] color, ArrayList<ArrayList<Integer>> adj, int i) {
		color[i] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		while (!q.isEmpty()) {
			Integer peek = q.peek();
			q.remove();
			for (Integer node : adj.get(peek)) {
				if (color[node] == -1) {
					q.add(node);
					color[node] = 1 - color[peek];
				} else if (color[node] == color[peek]) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean dfs(int col,int[] color, ArrayList<ArrayList<Integer>> adj, int i) {
		color[i] =col;
		for(int node : adj.get(i)) {
			if(color[node] == -1){
				if(dfs(1-col, color, adj, node) == false) {
					return false;
				}
            }
			else if(color[node] == col) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] graph = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
		boolean res = isBipartite(graph);
		System.out.println(res);
	}
}
