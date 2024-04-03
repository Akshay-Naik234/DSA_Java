package com.akshay.subsequnce;

import java.util.*;

public class LeetCode_216 {
	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		combinationSum3(k, n, 1, res, new ArrayList<>());
		return res;
	}

	public static void combinationSum3(int k, int n, int index, List<List<Integer>> res, List<Integer> temp) {
		if (k == 0 && n == 0) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = index; i <= 9; i++) {
			if (i > n) break;
			temp.add(i);
			combinationSum3(k - 1, n - i, i + 1, res, temp);
			temp.remove(temp.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		List<List<Integer>> res = combinationSum3(3, 9);
		System.out.println(res);
	}
}
