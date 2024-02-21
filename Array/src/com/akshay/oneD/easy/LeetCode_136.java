package com.akshay.oneD.easy;

public class LeetCode_136 {
	public static int singleNumber(int[] nums) {
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor = xor ^ nums[i]; 
        }
        return xor;
    }
	
	public static void main(String[] args) {
		int[] nums = {2,2,1,3,4,4,3};
		System.out.println(singleNumber(nums));
	}
}
