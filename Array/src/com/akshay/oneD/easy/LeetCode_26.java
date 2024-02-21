package com.akshay.oneD.easy;

//Remove Duplicates from Sorted Array
public class LeetCode_26 {

	private static int removeDuplicates(int[] arr) {
		int i=0;
		for(int j=1;j<arr.length;j++) {
			if(arr[i] != arr[j]) {
				arr[i+1] = arr[j];
				i++;
			}
		}
		return i+1;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,1,2,2,2,3};
		int k = removeDuplicates(arr);
		for(int i=0;i<k;i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
