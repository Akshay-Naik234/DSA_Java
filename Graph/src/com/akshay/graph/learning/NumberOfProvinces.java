package com.akshay.graph.learning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
	public static int findNumOfProvinces(int[][] roads, int n) {
		ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
		for(int i=0;i<n;i++) {
			adjacencyList.add(new ArrayList<Integer>());
		}
		int m = roads[0].length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(roads[i][j]==1) {
					adjacencyList.get(i).add(j);
				}
			}
		}
		int[] visited = new int[n];
		int cnt=0;
		for(int i=0;i<n;i++) {
			if(visited[i] == 0) {
				cnt++;
				dfs(i,adjacencyList,visited);
			}
			
		}
		return cnt;
	}

	private static void bfs(int start, ArrayList<ArrayList<Integer>> adjacencyList, int[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] =1;
		while(!q.isEmpty()) {
			Integer poll = q.poll();
			ArrayList<Integer> arrayList = adjacencyList.get(poll);
			for(int i : arrayList) {
				if(visited[i] == 0) {
					q.add(i);
					visited[i]=1;
				}	
			}
		}
	}
	
	private static void dfs(int start, ArrayList<ArrayList<Integer>> adjacencyList, int[] visited) {
		visited[start] = 1;
		for(Integer it : adjacencyList.get(start)) {
			if(visited[it] == 0) {
				dfs(it, adjacencyList, visited);
			}
		}
	}

	public static void main(String[] args) {
		int[][] roads = { { 1, 1, 1, 0 }, 
						  { 1, 1, 1, 0 },
						  { 1, 1, 1, 0 },
						  { 0, 0, 0, 1 } 
						};
		int n = 4;
		System.out.println(findNumOfProvinces(roads, n));
	}
	
}
