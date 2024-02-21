package com.akshay.oneD.hard;

import java.util.*;

public class LeetCode_229 {

	public static List<Integer> majorityElement(int[] nums) {

		List<Integer> res = new ArrayList<>();
		int n = nums.length;
		int el1 = Integer.MIN_VALUE;
		int el2 = Integer.MIN_VALUE;
		int counter1 = 0;
		int counter2 = 0;
		for (int i = 0; i < n; i++) {
			if (counter1 == 0 && el2 != nums[i]) {
				counter1 = 1;
				el1 = nums[i];
			} else if (counter2 == 0 && el1 != nums[i]) {
				counter2 = 1;
				el2 = nums[i];
			} else if (el1 == nums[i]) {
				counter1 += 1;
			} else if (el2 == nums[i]) {
				counter2 += 1;
			} else {
				counter1--;
				counter2--;
			}
		}
		int cnt1 = 0, cnt2 = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] == el1) {
				cnt1++;
			}
			if (nums[i] == el2) {
				cnt2++;
			}
		}
		int n1 = n / 3;
		if (cnt1 > n1) {
			res.add(el1);
		}
		if (cnt2 > n1) {
			res.add(el2);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {3,2,3};
		List<Integer> element = majorityElement(nums);
		System.out.println(element.toString());
	}
}
