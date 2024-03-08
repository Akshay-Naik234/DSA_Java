package com.akshay.graph.MST;

import java.util.*;
public class MST {
	
	static class Pair{
		int node;
		int weight;
		
		Pair(int node,int weight){
			this.node = node;
			this.weight = weight;
		}
	}
	
	public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
		int[] visited = new int[n];
		int wt = 0;
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}
		for(ArrayList<Integer> edge : edges) {
			adj.get(edge.get(0)).add(new Pair(edge.get(1), edge.get(2)));
			adj.get(edge.get(1)).add(new Pair(edge.get(0), edge.get(2)));
		}
		PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);
		pq.add(new Pair(0,0));
		while(!pq.isEmpty()) {
			int node = pq.peek().node;
			int weight = pq.peek().weight;
			pq.remove();
			if(visited[node] == 1) {
				continue;
			}
			wt+=weight;
			visited[node] = 1;
			for(int i=0;i<adj.get(node).size();i++) {
				int it = adj.get(node).get(i).node;
				int edgeWt = adj.get(node).get(i).weight;
				if(visited[it]==0) {
					pq.add(new Pair(it,edgeWt));
				}
			}
		}
		
		return wt;
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> edges = new ArrayList<>() {
			{
				add(new ArrayList<Integer>(Arrays.asList(1, 2, 6)));
				add(new ArrayList<Integer>(Arrays.asList(2, 3, 2)));
				add(new ArrayList<Integer>(Arrays.asList(1, 3, 2)));
				add(new ArrayList<Integer>(Arrays.asList(1, 0, 2)));
			}
		};
		int res = minimumSpanningTree(edges,4);
		System.out.println(res);
	}
}
