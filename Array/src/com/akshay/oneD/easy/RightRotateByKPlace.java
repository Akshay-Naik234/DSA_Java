package com.akshay.oneD.easy;

public class RightRotateByKPlace {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		int k =3;
		rightRotateByKPlace(arr,k);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

	// 1 2 3 4 5 6 7  --> question
	
	// 7 1 2 3 4 5 6
	// 6 7 1 2 3 4 5
	// 5 6 7 1 2 3 4
	private static void rightRotateByKPlace(int[] arr, int k) {
		int[] temp = new int[k];
		int n = arr.length;
		//7-3
		//4+7-3
		for(int i= n-k;i<n;i++) {
			temp[i-n+k] = arr[i];
		}
		for(int i=n-k-1;i>=0;i--) {
			arr[i+k] = arr[i];
		}
		for(int i=0;i<k;i++) {
			arr[i]=temp[i];
		}
	}
}
