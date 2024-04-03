package com.akshay.subsequnce;

import java.util.*;

public class LeetCode_90 {
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		Arrays.sort(nums);
		subsetsWithDupHelper(0, nums, nums.length, res, temp);
		return res;
	}

	public static void subsetsWithDupHelper(int ind, int[] nums, int n, List<List<Integer>> res, List<Integer> temp) {
		res.add(new ArrayList<>(temp));
		for (int i = ind; i < n; i++) {
			if (i > ind && nums[i] == nums[i - 1]) {
				continue;
			}
			temp.add(nums[i]);
			subsetsWithDupHelper(i + 1, nums, n, res, temp);
			temp.remove(temp.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		List<List<Integer>> res = subsetsWithDup(new int[] {1,2,2});
		System.out.println(res);
	}
}
