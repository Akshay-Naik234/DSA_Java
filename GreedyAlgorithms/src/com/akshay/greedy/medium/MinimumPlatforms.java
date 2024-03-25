package com.akshay.greedy.medium;

import java.util.Arrays;

public class MinimumPlatforms {
	static int findPlatform(int arr[], int dep[], int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		int i = 1;
		int j = 0;
		int cnt = 1;
		int res = 1;
		while (i < n && j < n) {
			if (arr[i] <= dep[j]) {
				cnt++;
				i++;
			} else if (arr[i] > dep[j]) {
				cnt--;
				j++;
			}
			if (cnt > res) {
				res = cnt;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr ={900,945,955,1100,1500,1800};
		int[] dep={920,1200,1130,1150,1900,2000};
		int n=arr.length;
		int totalCount=findPlatform(arr,dep,n);
		System.out.println(totalCount);
	}
}
