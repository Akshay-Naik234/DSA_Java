package com.akshay.oneD.easy;

import java.util.ArrayList;
import java.util.List;

public class Intersection_Of_2_SortedArray {
	public static void main(String[] args) {
		int[] a = {1,2,3,4};
		int[] b = {2,3};
		List<Integer> sortedArray = sortedArray(a, b);
		for(int i=0;i<sortedArray.size();i++) {
			System.out.print(sortedArray.get(i) + " ");
		}
	}

	private static List<Integer> sortedArray(int[] a, int[] b) {
		List<Integer> commonList = new ArrayList<>();
		int n = a.length;
		int m = b.length;
		int i=0,j=0;
		while(i<n && j<m) {
			if(a[i]<b[j]) {
				i++;
			}
			else if(b[j]<a[i]) {
				j++;
			}
			else {
				commonList.add(a[i]);
				i++;
				j++;
			}
		}
		return commonList;
	}
}
