package com.akshay.sorting;

public class InsertionSort {
	//If the index of i is 4 , till 4th index all the left element should be sorted
	public static void InsertionSort(int[] arr,int n) {
		for(int i=0;i<n;i++) {
			int j=i;
			while(j>0 && arr[j-1]>arr[j]) {
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
				j-=1;
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {12,45,23,51,19,8};
		int n = arr.length;
		InsertionSort(arr,n);
	}
}
