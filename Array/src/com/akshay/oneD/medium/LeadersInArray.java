package com.akshay.oneD.medium;

import java.util.*;

public class LeadersInArray {

	public static List<Integer> superiorElements(int[] a) {
		List<Integer> res = new ArrayList<>();
		int maxi = Integer.MIN_VALUE;
		int n = a.length;
		for (int i = n - 1; i >= 0; i--) {
			if (a[i] > maxi) {
				res.add(a[i]);
				maxi = a[i];
			}
		}
		Collections.sort(res);
		return res;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 2};
		List<Integer> res = superiorElements(a);
		for (Integer i : res) {
			System.out.print(i + " ");
		}
	}
}
