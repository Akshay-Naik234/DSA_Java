package com.akshay.oneD.medium;

public class LeetCode_75 {
	public static void sortColors(int[] nums) {
		int low = 0, mid = 0, high = nums.length - 1;
		int temp;
		while (mid <= high) {
			if (nums[mid] == 0) {
				temp = nums[low];
				nums[low] = nums[mid];
				nums[mid] = temp;
				low++;
				mid++;
			} else if (nums[mid] == 1) {
				mid++;
			} else if (nums[mid] == 2) {
				temp = nums[high];
				nums[high] = nums[mid];
				nums[mid] = temp;
				high--;
			}
		}
	}
	
	public static void main(String[] args) {
		int [] nums = {1,2,0,1,2,0,0,1,2};
		sortColors(nums);
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i] + " ");
		}
	}
}
