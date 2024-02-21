package com.akshay.sorting;

public class BubbleSort {
	//Compare each element with the next element
	public static void bubbleSort(int arr[],int n) {
		for(int i=n-1;i>=0;i--) {
			for(int j=0;j<=i-1;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j]=temp;
				}
			}
		}
		for(int i=0;i<n;i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int arr[] = {12,45,23,51,19,8};
		int n = arr.length;
		bubbleSort(arr,n);
	}
}
