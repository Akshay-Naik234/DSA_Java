package com.akshay.graph.BFSAndDFS;

public class LeetCode_1020 {
	public static int numEnclaves(int[][] grid) {
        int n = grid.length;
		int m = grid[0].length;
		int[][] visited = new int[n][m];

		for (int i = 0; i < m; i++) {
			if (visited[0][i] == 0  && grid[0][i] == 1) {
				dfs(0, i, grid, visited, n, m);
			}
		}
		for (int i = 0; i < m; i++) {
			if (visited[n - 1][i] == 0 && grid[n-1][i] == 1) {
				dfs(n - 1, i, grid, visited, n, m);
			}
		}
		for (int i = 0; i < n; i++) {
			if (visited[i][0] == 0 && grid[i][0] == 1) {
				dfs(i, 0, grid, visited, n, m);
			}
		}
		for (int i = 0; i < n; i++) {
			if (visited[i][m-1] == 0 && grid[i][m-1] == 1) {
				dfs(i, m - 1, grid, visited, n, m);
			}
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] == 0 && grid[i][j] == 1) {
					cnt++;
				}
			}
		}
        return cnt;
    }
    private static void dfs(int row, int col, int[][] grid, int[][] visited, int n, int m) {
		visited[row][col] = 1;
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		for (int i = 0; i < 4; i++) {
			int nrow = row + dr[i];
			int ncol = col + dc[i];
			if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && visited[nrow][ncol] == 0
					&& grid[nrow][ncol] == 1) {
				dfs(nrow, ncol, grid, visited, n, m);
			}
		}
	}
    
    public static void main(String[] args)
    {
        int grid[][] = {
        {0, 0, 0, 0},
        {1, 0, 1, 0},
        {0, 1, 1, 0},
        {0, 0, 0, 0}};

        int ans = numEnclaves(grid);
        System.out.println(ans);
    }
}
