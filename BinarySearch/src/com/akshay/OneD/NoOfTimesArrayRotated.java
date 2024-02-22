package com.akshay.OneD;

public class NoOfTimesArrayRotated {
	public static int findKRotation(int[] arr) {
		int low = 0;
		int high = arr.length - 1;
		int mid;
		int ans = Integer.MAX_VALUE;
		int index = -1;
		while (low <= high) {
			mid = (low + high) / 2;
			if (arr[low] <= arr[high]) {
				if(arr[low]<ans) {
					index = low;
					ans = arr[low];
				}
				break;
			}
			if (arr[low] <= arr[mid]) {
				if (arr[low] < ans) {
					index = low;
					ans = arr[low];
				}
				low = mid + 1;
			} else if (arr[mid] <= arr[high]) {
				if (arr[mid] < ans) {
					index = mid;
					ans = arr[mid];
				}
				high = mid - 1;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {27, 31 ,43 ,45 ,46, 5, 11, 13, 18, 19, 20 };
		int rotation = findKRotation(arr);
		System.out.println(rotation);
	}
}
