package com.akshay.oneD.easy;

public class LargestElement {
	
	public static void main(String[] args) {
		int[] arr = {4,5,2,1,3};
		int maxi = findLargest(arr);
		System.out.println(maxi);
	}

	private static int findLargest(int[] arr) {
		int maxi = arr[0];
		for(int i=1 ;i<arr.length;i++) {
			if(arr[i]>maxi) {
				maxi = arr[i];
			}
		}
		return maxi;
	}
}
