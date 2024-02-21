package com.akshay.sorting;

public class QuickSort {

	public static void qs(int[] arr, int low, int high) {
		if (low < high) {
			int partionIdex = getPartitionIndex(arr, low, high);
			qs(arr, low, partionIdex - 1);
			qs(arr, partionIdex + 1, high);
		}

	}

	private static int getPartitionIndex(int[] arr, int low, int high) {
		int i = low;
		int j = high;
		int pivot = low;
		while (i < j) {
			while (arr[i] <= arr[pivot] && i < high) {
				i++;
			}
			while (arr[j] > arr[pivot] && j > low) {
				j--;
			}
			if (i < j) {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[pivot];
		arr[pivot] = arr[j];
		arr[j] = temp;
		return j;
	}

	public static void main(String[] args) {
		int arr[] = { 4, 5, 2, 6, 3, 8 };
		int n = arr.length;
		qs(arr, 0, n - 1);
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
