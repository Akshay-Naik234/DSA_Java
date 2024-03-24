package com.akshay.medium;

public class LeetCode_1248 {
	public static int numberOfSubarrays(int[] nums, int k) {
		return subArraySumAtMostK(nums, k) - subArraySumAtMostK(nums, k - 1);
	}

	public static int subArraySumAtMostK(int[] nums, int k) {
		int start = 0;
		int count = 0;
		int res = 0;
		for (int end = 0; end < nums.length; end++) {
			if (nums[end] % 2 == 1) {
				count++;
			}
			while (count > k && start <= end) {
				if (nums[start] % 2 == 1) {
					count--;
				}
				start++;
			}
			res += (end - start + 1);
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,1,2,1,1};
		int res = numberOfSubarrays(nums, 3);
		System.out.println(res);
		
	}
}
