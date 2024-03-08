package com.akshay.graph.MST;

public class NumberOfIsland11 {
	public static int[] numberOfIslandII(int n, int m, int[][] queries, int q) {
		int[][] visited = new int[n][m];
		int[] ans = new int[q];
		DisJointSet ds = new DisJointSet(n * m);
		int cnt = 0;
		for (int i = 0; i < q; i++) {
			int row = queries[i][0];
			int col = queries[i][1];
			if (visited[row][col] == 1) {
				ans[i] = cnt;
				continue;
			}
			visited[row][col] = 1;
			cnt++;
			int[] dr = { -1, 0, 1, 0 };
			int[] dc = { 0, -1, 0, 1 };
			for (int j = 0; j < 4; j++) {
				int nrow = row + dr[j];
				int ncol = col + dc[j];
				if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
					if (visited[nrow][ncol] == 1) {
						int node = row * m + col;
						int adjNode = nrow * m + ncol;
						if (ds.getUParent(node) != ds.getUParent(adjNode)) {
							cnt--;
							ds.unionByRank(node, adjNode);
						}
					}
				}
			}
			ans[i] = cnt;
		}
		return ans;
	}
	
	public static void main (String[] args) {
        int n = 4, m = 5;
        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1},
            {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}
        };

        int[] ans = numberOfIslandII(n, m, operators,12);

        for(int p:ans) {
        	System.out.print(p + " ");
        }
        System.out.println("");
    }
}
