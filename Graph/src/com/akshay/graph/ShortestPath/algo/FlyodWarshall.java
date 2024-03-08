package com.akshay.graph.ShortestPath.algo;

public class FlyodWarshall {
	public static void shortest_distance(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == -1) {
					matrix[i][j] = (int) 1e9;
				}
			}
			matrix[i][i] = 0;
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 1e9) {
					matrix[i][j] = -1;
				}
			}
		}
	}

	public static void main(String[] args) {
		int V = 4;
		int[][] matrix = new int[V][V];

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				matrix[i][j] = -1;
			}
		}

		matrix[0][1] = 2;
		matrix[1][0] = 1;
		matrix[1][2] = 3;
		matrix[3][0] = 3;
		matrix[3][1] = 5;
		matrix[3][2] = 4;
		shortest_distance(matrix);
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
