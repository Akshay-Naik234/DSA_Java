package com.akshay.interview;

public class LeetCode_136 {
	public static int singleNumber(int[] nums) {
        int res = 0;
        for(int i=0;i<nums.length;i++){
            res = res ^ nums[i];
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,3,1,4,5,3,4};
		int singleNumber = singleNumber(nums);
		System.out.println(singleNumber);
	}
}
