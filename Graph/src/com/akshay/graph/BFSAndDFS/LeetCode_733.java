package com.akshay.graph.BFSAndDFS;

public class LeetCode_733 {
	public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
		int[][] ans = image;
		int[] dr = { -1, 0, 1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		int initialColor = image[sr][sc];
		ans = dfs(image, sr, sc, color, ans, dr, dc, initialColor);
		return ans;
	}

	private static int[][] dfs(int[][] image, int sr, int sc, int color, int[][] ans, int[] dr, int[] dc,
			int initialColor) {
		ans[sr][sc] = color;
		int n = image.length;
		int m = image[0].length;
		for (int i = 0; i < 4; i++) {
			int nrow = dr[i] + sr;
			int ncol = dc[i] + sc;
			if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && ans[nrow][ncol] != color
					&& image[nrow][ncol] == initialColor) {
				dfs(image, nrow, ncol, color, ans, dr, dc, initialColor);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int[][] res = floodFill(arr, 1, 1, 2);
		for (int[] is : res) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
