package com.akshay.medium;

import java.util.*;

public class LeetCode_1004 {
	public static int longestOnes(int[] nums, int k) {
		Queue<Integer> q = new LinkedList<>();
		int n = nums.length;
		int count = 0;
		int maxi = 0;
		for (int i = 0; i < n; i++) {
			while (i < n && nums[i] == 1) {
				i++;
				count++;
			}
			maxi = Math.max(maxi, count);
			if (i == n) {
				break;
			}
			if (k > 0) {
				count++;
				k--;
				q.add(i);
			} else {
				if (!q.isEmpty()) {
					count = i - q.remove();
					q.add(i);
				} else {
					count = 0;
				}
			}
			maxi = Math.max(maxi, count);
		}
		return maxi;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
		int res = longestOnes(arr, 2);
		System.out.println(res);
	}
}
