package com.akshay.oneD.easy;

// Left Rotate an Array by One
public class LeftRotateOnePlace {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5 };
		leftRotateByOnePlace(arr, arr.length,4);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		int arr1[] = { 1, 2, 3, 4, 5 };
		rightRotateByOnePlace(arr1, arr1.length);
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] + " ");
		}
	}

	// 1 2 3 4 5
	// 2 3 4 5 1
	private static void leftRotateByOnePlace(int[] arr, int length, int k) {
		k = k % length;
		for (int i = 0; i < k; i++) {
			int last = arr[0];
			for (int j = 1; j < length; j++) {
				arr[j - 1] = arr[j];
			}
			arr[length - 1] = last;
		}

	}

	// 1 2 3 4 5
	// 5 1 2 3 4
	private static void rightRotateByOnePlace(int[] arr1, int length) {
		int first = arr1[length - 1];
		for (int j = length - 2; j >= 0; j--) {
			arr1[j + 1] = arr1[j];
		}
		arr1[0] = first;
	}
}
