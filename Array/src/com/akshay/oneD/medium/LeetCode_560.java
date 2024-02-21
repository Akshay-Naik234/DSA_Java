package com.akshay.oneD.medium;

import java.util.*;

public class LeetCode_560 {
	public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum=0;
        int count = 0;
        int rem;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            rem = sum - k;
            if(map.containsKey(rem)){
                count = count + map.get(rem);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,1,1};
		int k= 2;
		System.out.println(subarraySum(nums, k));
	}
}
