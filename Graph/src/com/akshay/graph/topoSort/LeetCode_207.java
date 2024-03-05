package com.akshay.graph.topoSort;

import java.util.*;

public class LeetCode_207 {

	public static boolean detectCycleInDirectedGraph(int v, ArrayList<ArrayList<Integer>> adj) {
		int[] indegree = new int[v];
		Queue<Integer> q = new LinkedList<>();
		int cnt = 0;
		for (int i = 0; i < v; i++) {
			for (int in : adj.get(i)) {
				indegree[in]++;
			}
		}
		for (int i = 0; i < v; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			Integer peek = q.peek();
			cnt++;
			q.remove();
			for (int it : adj.get(peek)) {
				indegree[it]--;
				if (indegree[it] == 0) {
					q.add(it);
				}
			}
		}
		return cnt == v;
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i <= numCourses; i++) {
			adj.add(new ArrayList<Integer>());
		}
		for (int[] edge : prerequisites) {
			adj.get(edge[0]).add(edge[1]);
		}
		return detectCycleInDirectedGraph(numCourses, adj);
	}
	
	public static void main(String[] args) {
		int[][] prerequisites = {{1,0},{0,1}};
		boolean res = canFinish(2, prerequisites);
		System.out.println(res);
	}
}
