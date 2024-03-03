package com.akshay.graph.BFSAndDFS;

import java.util.*;

public class CycleInUnDirectedGraphBFS {

	static class Pair {
		int node;
		int parent;

		Pair(int node, int parent) {
			this.node = node;
			this.parent = parent;
		}
	}

	static boolean detectCycle(int V, List<List<Integer>> adj) {
		int[] visited = new int[V];

		for (int i = 0; i < V; i++) {
			if (visited[i] == 0 && isCycleExists(i, V, adj, visited) == true) {
				return true;
			}
		}
		return false;
	}

	private static boolean isCycleExists(int i, int v, List<List<Integer>> adj, int[] visited) {

		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(i, -1));
		visited[i] = 1;
		while (!q.isEmpty()) {
			Integer node = q.peek().node;
			Integer parent = q.peek().parent;
			q.remove();
			for (int it : adj.get(node)) {
				if (visited[it] == 0) {
					q.add(new Pair(it, node));
					visited[it] = 1;
				} else if (it != parent) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args)
    {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
                
        boolean ans = detectCycle(4, adj);
        if (ans)
            System.out.println("1");    
        else
            System.out.println("0");
    }

}
