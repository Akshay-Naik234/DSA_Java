package com.akshay.TwoD;

import java.util.ArrayList;
import java.util.Arrays;

public class FindTheRowWithMax1s {

	public static int findLowerBound(ArrayList<Integer> arr) {
		int low = 0;
		int high = arr.size() - 1;
		int mid;
		int ans = -1;
		while (low <= high) {
			mid = (low + high) / 2;
			if (arr.get(mid) == 1) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
		int res = -1;
		int index = -1;
		for (int i = 0; i < n; i++) {
			int lowerBound = findLowerBound(matrix.get(i));
			if (lowerBound != -1) {
				if ((m - lowerBound) > res) {
					res = m - lowerBound;
					index = i;
				}
			}

		}
		return index;
	}

	public static void main(String[] args) {
		ArrayList<Integer> arr1 = new ArrayList<Integer>(Arrays.asList(1, 1, 1));
		ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(0, 0, 1));
		ArrayList<Integer> arr3 = new ArrayList<Integer>(Arrays.asList(0, 0, 0));
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		matrix.addAll(Arrays.asList(arr1, arr2, arr3));
		System.out.println(maximumOnesRow(matrix, 3, 3));
	}
}
