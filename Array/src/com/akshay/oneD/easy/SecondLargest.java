package com.akshay.oneD.easy;

public class SecondLargest {

	public static void main(String[] args) {
		int[] arr = { 4, 3, 5, 7, 6, 2, 7 };
		int secondLarge = secondLargestElement(arr);
		System.out.println(secondLarge);
		int secondSmallest = secondSmallestElement(arr);
		System.out.println(secondSmallest);
	}

	private static int secondLargestElement(int[] arr) {
		int largest = arr[0];
		int secondLargest = Integer.MIN_VALUE;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > largest) {
				secondLargest = largest;
				largest = arr[i];
			} else if (arr[i] > secondLargest && arr[i] != largest) {
				secondLargest = arr[i];
			}
		}
		return secondLargest;
	}

	private static int secondSmallestElement(int[] arr) {
		int smallest = arr[0];
		int secondSmallest = Integer.MAX_VALUE;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < smallest) {
				secondSmallest = smallest;
				smallest = arr[i];
			} else if (arr[i] < secondSmallest && arr[i] != smallest) {
				secondSmallest = arr[i];
			}
		}
		return secondSmallest;
	}
}
