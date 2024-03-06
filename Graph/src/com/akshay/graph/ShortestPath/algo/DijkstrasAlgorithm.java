package com.akshay.graph.ShortestPath.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
	int node;
	int distance;

	public Pair(int node, int distance) {
		this.node = node;
		this.distance = distance;
	}
}

public class DijkstrasAlgorithm {

	public static List<Integer> dijkstra(int[][] edge, int vertices, int edges, int source) {
		int[] dist = new int[vertices];
		List<List<Pair>> adj = new ArrayList<>();

		for (int j = 0; j < vertices; j++) {
			adj.add(new ArrayList<Pair>());
		}

		for (int e[] : edge) {
			adj.get(e[0]).add(new Pair(e[1], e[2]));
			adj.get(e[1]).add(new Pair(e[0], e[2]));
		}

		PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
		for (int i = 0; i < vertices; i++) {
			dist[i] = (int) 1e9;
		}
		dist[source] = 0;
		pq.add(new Pair(source, 0));
		while (!pq.isEmpty()) {
			int distance = pq.peek().distance;
			int node = pq.peek().node;
			pq.remove();
			for (int p = 0; p < adj.get(node).size(); p++) {
				int it = adj.get(node).get(p).node;
				int edgeWeight = adj.get(node).get(p).distance;
				if (distance + edgeWeight < dist[it]) {
					dist[it] = distance + edgeWeight;
					pq.add(new Pair(it, dist[it]));
				}
			}
		}

		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < vertices; i++) {
			if (dist[i] == (int) 1e9) {
				dist[i] = -1;
			}
			res.add(dist[i]);
		}
		return res;

	}

	public static void main(String[] args) {
		int[][] edge = { { 0, 1, 7 }, { 0, 2, 1 }, { 0, 3, 2 }, { 1, 2, 3 }, { 1, 3, 5 }, { 1, 4, 1 }, { 3, 4, 7 } };
		int vertices = 5;
		int edges = 7;
		int source = 0;
		List<Integer> res = dijkstra(edge, vertices, edges, source);
		System.out.println(res);

	}
}
