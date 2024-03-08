package com.akshay.graph.ShortestPath.algo;

import java.util.*;

public class LeeCode_743 {
	static class Pair {
		int node;
		int weight;

		Pair(int node, int weight) {
			this.node = node;
			this.weight = weight;
		}
	}

	public static int networkDelayTime(int[][] times, int n, int k) {
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<>());
		}
		for (int[] time : times) {
			adj.get(time[0]).add(new Pair(time[1], time[2]));
		}
		int[] dist = new int[n + 1];
		Arrays.fill(dist, (int) 1e9);
		dist[k] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
		pq.add(new Pair(k, 0));
		while (!pq.isEmpty()) {
			int node = pq.peek().node;
			int weight = pq.peek().weight;
			pq.remove();
			for (int i = 0; i < adj.get(node).size(); i++) {
				int it = adj.get(node).get(i).node;
				int edgeWeight = adj.get(node).get(i).weight;
				if (weight + edgeWeight < dist[it]) {
					dist[it] = weight + edgeWeight;
					pq.add(new Pair(it, weight + edgeWeight));
				}
			}
		}
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if (dist[i] == (int) 1e9) {
				return -1;
			}
			ans = Math.max(ans, dist[i]);
		}
		return ans;
	}

	public static void main(String[] args) {
		int[][] times = { { 1, 2, 1 }, { 2, 1, 3 } };
		int n = 2;
		int k = 2;
		int res = networkDelayTime(times, n, k);
		System.out.println(res);
	}
}
