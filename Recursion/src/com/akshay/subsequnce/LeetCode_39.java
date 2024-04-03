package com.akshay.subsequnce;

import java.util.*;

public class LeetCode_39 {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		combinationSum(0, candidates, candidates.length, target, res, temp);
		return res;
	}

	public static void combinationSum(int ind, int[] candidates, int n, int target, List<List<Integer>> res,
			List<Integer> temp) {
		if (ind == n) {
			if (target == 0) {
				res.add(new ArrayList<>(temp));
			}
			return;
		}
		temp.add(candidates[ind]);
		if (candidates[ind] <= target) {
			combinationSum(ind, candidates, n, target - candidates[ind], res, temp);
		}
		temp.remove(temp.size() - 1);
		combinationSum(ind + 1, candidates, n, target, res, temp);
	}

	public static void main(String[] args) {
		int[] candidates = { 2, 3, 6, 7 };
		int target = 7;
		List<List<Integer>> res = combinationSum(candidates, target);
		System.out.println(res);
	}
}
