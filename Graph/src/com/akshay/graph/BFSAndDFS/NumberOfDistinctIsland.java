package com.akshay.graph.BFSAndDFS;

import java.util.ArrayList;
import java.util.HashSet;

public class NumberOfDistinctIsland {
	public static int distinctIsland(int[][] arr, int n, int m) {
		int[][] visited = new int[n][m];
		HashSet<ArrayList<String>> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] == 0 && arr[i][j] == 1) {
					ArrayList<String> list = new ArrayList<>();
					dfs(i, j, arr, visited, n, m,i,j,list);
					set.add(list);
				}
			}
		}
		return set.size();
	}

	private static void dfs(int row, int col, int[][] arr, int[][] visited, int n, int m,int row0,int col0,ArrayList<String> list) {
		visited[row][col] = 1;
		int r = row-row0;
		int c = col-col0;
		list.add(r +","+c);
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		
		for (int i = 0; i < 4; i++) {
			int nrow = row + dr[i];
			int ncol = col + dc[i];
			if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0 && arr[nrow][ncol] == 1) {
				dfs(nrow, ncol, arr, visited, n, m,row0,col0,list);
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] arr = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
		int res = distinctIsland(arr,4,5);
		System.out.println(res);
	}
}
