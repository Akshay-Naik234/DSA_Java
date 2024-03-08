package com.akshay.graph.ShortestPath.algo;

import java.util.*;

public class LeetCode_787 {
	static class Pair {
		int node;
		int price;

		Pair(int node, int price) {
			this.node = node;
			this.price = price;
		}
	}

	static class tuple {
		int steps;
		int node;
		int price;

		tuple(int steps, int node, int price) {
			this.steps = steps;
			this.node = node;
			this.price = price;
		}
	}

	public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}
		for (int[] flight : flights) {
			adj.get(flight[0]).add(new Pair(flight[1], flight[2]));
		}
		int[] dist = new int[n];
		Arrays.fill(dist, (int) 1e9);
		Queue<tuple> q = new LinkedList<>();
		q.add(new tuple(0, src, 0));
		while (!q.isEmpty()) {
			int steps = q.peek().steps;
			int node = q.peek().node;
			int price = q.peek().price;
			q.remove();
			if (steps > k) {
				continue;
			}
			for (int i = 0; i < adj.get(node).size(); i++) {
				int it = adj.get(node).get(i).node;
				int edgePrice = adj.get(node).get(i).price;
				if (price + edgePrice < dist[it] && steps <= k) {
					dist[it] = price + edgePrice;
					q.add(new tuple(steps + 1, it, price + edgePrice));
				}
			}
		}
		if (dist[dst] == (int) 1e9) {
			return -1;
		}
		return dist[dst];
	}
	
	 public static void main(String[] args) {
	       
	        int n = 4, src = 0, dst = 3, K = 1;
	        int[][] flights={{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};

	        int ans = findCheapestPrice(n,flights,src,dst,K);
	        
	        System.out.print(ans);
	        System.out.println();
	    }
}
