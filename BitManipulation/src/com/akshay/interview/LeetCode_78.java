package com.akshay.interview;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_78 {

	public static List<Integer> getTemp(int num, int[] nums) {
		List<Integer> temp = new ArrayList<>();
		int cur_pos = 0;
		while (num > 0) {
			if ((num & 1) > 0) {
				if (cur_pos != nums.length) {
					temp.add(nums[cur_pos]);
				}
			}
			cur_pos++;
			num = num >> 1;
		}
		return temp;
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		int pow = (int) Math.pow(2, nums.length);
		for (int i = 1; i <= pow; i++) {
			List<Integer> temp = getTemp(i, nums);
			res.add(temp);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1 };
		List<List<Integer>> subsets = subsets(nums);
		for (List<Integer> list : subsets) {
			System.out.println(list);
		}
	}
}
