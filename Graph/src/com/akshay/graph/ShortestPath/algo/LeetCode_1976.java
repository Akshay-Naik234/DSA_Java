package com.akshay.graph.ShortestPath.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode_1976 {

	static class Pair {
		int first;
		long second;

		public Pair(int first, long second) {
			this.first = first;
			this.second = second;
		}
	}

	public static int countPaths(int n, int[][] roads) {
		int mod = 1000000007;
		long[] dist = new long[n];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[0] = 0;

		List<List<Pair>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int[] road : roads) {
			adjList.get(road[0]).add(new Pair(road[1], road[2]));
			adjList.get(road[1]).add(new Pair(road[0], road[2]));
		}

		long[] ways = new long[n];
		ways[0] = 1;

		PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingLong(a -> a.second));
		minHeap.offer(new Pair(0, 0));

		while (!minHeap.isEmpty()) {
			Pair curr = minHeap.poll();
			long d = curr.second;
			int u = curr.first;
			if (d > dist[u])
				continue;

			for (int i = 0; i < adjList.get(u).size(); i++) {
				int v = adjList.get(u).get(i).first;
				long w = adjList.get(u).get(i).second;
				if (dist[v] > d + w) {
					dist[v] = d + w;
					minHeap.add(new Pair(v, dist[v]));
					ways[v] = ways[(int) u];
				} else if (dist[v] == d + w) {
					ways[v] = (ways[v] + ways[(int) u]) % mod;
				}
			}
		}

		return (int) ways[n - 1];
	}

	public static void main(String[] args) {

		int n = 6;
		int[][] roads = { { 0, 1, 1000000000 }, { 0, 3, 1000000000 }, { 1, 3, 1000000000 }, { 1, 2, 1000000000 },
				{ 1, 5, 1000000000 }, { 3, 4, 1000000000 }, { 4, 5, 1000000000 }, { 2, 5, 1000000000 } };
		int ans = countPaths(n, roads);

		System.out.print(ans);
	}
}
