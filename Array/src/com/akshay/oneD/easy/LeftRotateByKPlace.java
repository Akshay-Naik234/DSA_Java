package com.akshay.oneD.easy;

import java.util.ArrayList;

public class LeftRotateByKPlace {

	// 1 2 3 4 5 6 7 k=3

	// 2 3 4 5 6 7 1
	// 3 4 5 6 7 1 2
	// 4 5 6 7 1 2 3
	public static void leftRotateUsingArray(int[] arr, int n, int k) {

		k = k % n;

		if (n == 0) {
			return;
		}
		int[] temp = new int[k];
		for (int i = 0; i < k; i++) {
			temp[i] = arr[i];
		}
		for (int i = 0; i < n - k; i++) {
			arr[i] = arr[i + k];
		}
		for (int i = n - k; i < n; i++) {
			arr[i] = temp[i - n + k];
		}

	}

	public static void leftRotateUsingArrayList(ArrayList<Integer> arr1, int k) {

		int n = arr1.size();
		k = k % n;

		int[] temp = new int[k];
		for (int i = 0; i < k; i++) {
			// temp[i]=arr[i];
			temp[i] = arr1.get(i);
		}
		for (int i = 0; i < n - k; i++) {
			// arr[i]=arr[i+k];
			arr1.set(i, arr1.get(i + k));
		}
		for (int i = n - k; i < n; i++) {
			arr1.set(i, temp[i - n + k]);
		}
		System.out.println(arr1);

	}

	public static void main(String[] args) {
		int[] arr = { 1, 2,3,4,5,6 };
		int nums = arr.length;
		leftRotateUsingArray(arr,nums,3);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		ArrayList<Integer> arr1 = new ArrayList<>();
		arr1.add(1);
		arr1.add(2);
		int k = 1;
		leftRotateUsingArrayList(arr1,k);
		
	}
}
