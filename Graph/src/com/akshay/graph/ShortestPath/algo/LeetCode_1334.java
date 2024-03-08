package com.akshay.graph.ShortestPath.algo;

import java.util.*;

public class LeetCode_1334 {
	public static int findTheCity(int n, int[][] edges, int distanceThreshold) {

		int[][] matrix = new int[n][n];
		for (int[] mat : matrix) {
			Arrays.fill(mat, (int) 1e9);
		}
		for (int i = 0; i < n; i++) {
			matrix[i][i] = 0;
		}
		for (int[] edge : edges) {
			matrix[edge[0]][edge[1]] = edge[2];
			matrix[edge[1]][edge[0]] = edge[2];
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
				}
			}
		}

		int cntCity = n;
		int ans = -1;
		for (int i = 0; i < n; i++) {
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] <= distanceThreshold) {
					cnt++;
				}
			}
			if (cnt <= cntCity) {
				cntCity = cnt;
				ans = i;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] edges = { { 0, 1, 3 }, { 1, 2, 1 }, { 1, 3, 4 }, { 2, 3, 1 } };
		int distanceThreshold = 4;

		int cityNo = findTheCity(n, edges, distanceThreshold);
		System.out.println(cityNo);
	}
}
