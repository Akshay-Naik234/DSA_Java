package com.akshay.graph.topoSort;

import java.util.*;

public class LeetCode_210 {
	public static int[] topoOrder(int v, ArrayList<ArrayList<Integer>> adj) {
		int[] indegree = new int[v];
		Queue<Integer> q = new LinkedList<>();
		int[] res = new int[v];
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
		int s = v - 1;
		while (!q.isEmpty()) {
			Integer peek = q.peek();
			res[s] = peek;
			s--;
			cnt++;
			q.remove();
			for (int it : adj.get(peek)) {
				indegree[it]--;
				if (indegree[it] == 0) {
					q.add(it);
				}
			}
		}
		if (cnt == v) {
			return res;
		}
		int[] arr = {};
		return arr;
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i <= numCourses; i++) {
			adj.add(new ArrayList<Integer>());
		}
		for (int[] edge : prerequisites) {
			adj.get(edge[0]).add(edge[1]);
		}
		return topoOrder(numCourses, adj);
	}
	
	public static void main(String[] args) {
		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		int[] res = findOrder(4, prerequisites);
		for(int i:res) {
			System.out.print(i + " ");
		}
	}
}
