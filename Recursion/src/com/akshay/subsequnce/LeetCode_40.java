package com.akshay.subsequnce;

import java.util.*;

public class LeetCode_40 {
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		combinationSum(0, candidates, candidates.length, target, res, temp);
		return res;
	}

	public static void combinationSum(int ind, int[] candidates, int n, int target, List<List<Integer>> res,
			List<Integer> temp) {
		if (target == 0) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = ind; i < n; i++) {
			if (i > ind && candidates[i] == candidates[i - 1]) {
				continue;
			}
			if (candidates[i] > target) {
				break;
			}
			temp.add(candidates[i]);
			combinationSum(i + 1, candidates, n, target - candidates[i], res, temp);
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		List<List<Integer>> res = combinationSum2(candidates, 8);
		System.out.println(res);
	}
}
