package com.akshay.sorting;

public class SelectionSort {

	//Find the minimum element in unsorted array and swap it with element at beginning
	public static void selectionSort(int arr[], int n) {
		for (int i = 0; i < n; i++) {
			int mini = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[mini]) {
					mini = j;
				}
			}
			int temp = arr[mini];
			arr[mini] = arr[i];
			arr[i] = temp;
		}

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void main(String[] args) {
		int[] arr = { 12, 45, 23, 51, 19, 8 };
		int n = arr.length;
		selectionSort(arr, n);
	}
}
