package com.akshay.graph.MST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal_Algo {

	static class Edge implements Comparable<Edge> {
		int src;
		int dest;
		int weight;

		Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}

	}

	static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
		List<Edge> edges = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < adj.get(i).size(); j++) {
				int dest = adj.get(i).get(j).get(0);
				int weight = adj.get(i).get(j).get(1);
				edges.add(new Edge(i, dest, weight));
			}
		}
		int res = 0;
		DisJointSet ds = new DisJointSet(V);
		Collections.sort(edges);
		for (Edge e : edges) {
			int src = e.src;
			int dest = e.dest;
			int weight = e.weight;
			if (ds.getUParent(src) != ds.getUParent(dest)) {
				res += weight;
				ds.unionByRank(src, dest);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int V = 5;
		ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
		int[][] edges = { { 0, 1, 2 }, { 0, 2, 1 }, { 1, 2, 1 }, { 2, 3, 2 }, { 3, 4, 1 }, { 4, 2, 2 } };

		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<ArrayList<Integer>>());
		}

		for (int i = 0; i < 6; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int w = edges[i][2];

			ArrayList<Integer> tmp1 = new ArrayList<Integer>();
			ArrayList<Integer> tmp2 = new ArrayList<Integer>();
			tmp1.add(v);
			tmp1.add(w);

			tmp2.add(u);
			tmp2.add(w);

			adj.get(u).add(tmp1);
			adj.get(v).add(tmp2);
		}

		int mstWt = spanningTree(V, adj);
		System.out.println("The sum of all the edge weights: " + mstWt);

	}
}
