package com.akshay.graph.topoSort;

import java.util.*;

public class AlienDictionary {

	public static List<Integer> topoOrder(int v, ArrayList<ArrayList<Integer>> adj) {
		int[] indegree = new int[v];
		Queue<Integer> q = new LinkedList<>();
		List<Integer> res = new ArrayList<>();
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
			res.add(peek);
			q.remove();
			for (int it : adj.get(peek)) {
				indegree[it]--;
				if (indegree[it] == 0) {
					q.add(it);
				}
			}
		}
		return res;
	}

	public static String getAlienLanguage(String[] dictionary, int k) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

		for (int i = 0; i < k; i++) {
			adj.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < dictionary.length - 1; i++) {
			String s1 = dictionary[i];
			String s2 = dictionary[i + 1];
			int n1 = s1.length();
			int n2 = s2.length();
			int l = Math.min(n1, n2);
			for (int ptr = 0; ptr < l; ptr++) {
				if (s1.charAt(ptr) != s2.charAt(ptr)) {
					adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
					break;
				}
			}
		}
		List<Integer> res = topoOrder(k, adj);
		String result = "";
		for (int p : res) {
			result += (char) (p + (int) ('a'));
		}
		return result;
	}

	public static void main(String[] args) {
		String[] dictionary = { "caa", "aaa", "aab" };
		System.out.println(getAlienLanguage(dictionary, 3));
	}
}
