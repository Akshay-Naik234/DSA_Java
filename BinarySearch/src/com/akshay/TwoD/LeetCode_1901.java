package com.akshay.TwoD;

public class LeetCode_1901 {
	public static int findMaxRow(int[][] mat, int mid, int n) {
		int ans = mat[0][mid];
		int index = 0;
		for (int i = 1; i < n; i++) {
			if (mat[i][mid] > ans) {
				ans = mat[i][mid];
				index = i;
			}
		}
		return index;
	}

	public static int[] findPeakGrid(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;
		int low = 0;
		int high = m - 1;
		int[] res = { -1, -1 };
		while (low <= high) {
			int mid = (low + high) / 2;
			int rowMax = findMaxRow(mat, mid, n);
			int left = (mid - 1) > 0 ? mat[rowMax][mid - 1] : -1;
			int right = (mid + 1) < m ? mat[rowMax][mid + 1] : -1;
			if (left < mat[rowMax][mid] && right < mat[rowMax][mid]) {
				res[0] = rowMax;
				res[1] = mid;
				return res;
			}
			if (left > mat[rowMax][mid]) {
				high = mid - 1;
			} else if (right > mat[rowMax][mid]) {
				low = mid + 1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[][] mat = {{1,4},{3,2}};
		int[] findPeakGrid = findPeakGrid(mat);
		System.out.println(findPeakGrid[0] + " " + findPeakGrid[1]);
	}
}
