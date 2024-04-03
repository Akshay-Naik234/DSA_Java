package com.akshay.subsequnce;

import java.util.*;

public class SubSetSum {
	public static ArrayList<Integer> subsetSum(int num[]) {
		ArrayList<Integer> res = new ArrayList<>();
		subsetSumHelper(0, 0, num, num.length, res);
		Collections.sort(res);
		return res;
	}

	public static void subsetSumHelper(int ind, int sum, int[] num, int n, ArrayList<Integer> res) {
		if (ind == n) {
			res.add(sum);
			return;
		}
		subsetSumHelper(ind + 1, sum + num[ind], num, n, res);
		subsetSumHelper(ind + 1, sum, num, n, res);
	}
	
	public static void main(String[] args) {
		int[] num = {1,2,3};
		ArrayList<Integer> res = subsetSum(num);
		System.out.println(res);
	}
}
