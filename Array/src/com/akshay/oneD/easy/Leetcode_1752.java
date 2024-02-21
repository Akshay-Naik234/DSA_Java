package com.akshay.oneD.easy;

//1752. Check if Array Is Sorted and Rotated
public class Leetcode_1752 {

	private static boolean check(int[] arr) {
		int counter = 0 ;
		int n = arr.length;
		for(int i=0;i<n;i++) {
			if(arr[i]>arr[(i+1)%n]) {
				counter++;
			}
			if(counter>1) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] arr = {3,4,5,1,2};
		System.out.println(check(arr));
	}
}
