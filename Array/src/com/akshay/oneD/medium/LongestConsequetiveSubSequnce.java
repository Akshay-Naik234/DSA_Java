package com.akshay.oneD.medium;

import java.util.*;

public class LongestConsequetiveSubSequnce {

	public static int longestSuccessiveElements(int[] a) {
		Set<Integer> set = new HashSet<>();
		int counter = 1;
		int x = 0;
		int maxi = 0;
		int n = a.length;
		for (int i = 0; i < n; i++) {
			set.add(a[i]);
		}
		for (int it : set) {
			if (!set.contains(it - 1)) {
				counter = 1;
				x = it;
				while (set.contains(x + 1)) {
					x = x + 1;
					counter = counter + 1;
				}
				maxi = Math.max(maxi, counter);
			}
		}
		return maxi;
	}
	
	public static void main(String[] args) {
		int[] a = {5, 8, 3, 2, 1, 4};
		int i = longestSuccessiveElements(a);
		System.out.println(i);
	}
}
