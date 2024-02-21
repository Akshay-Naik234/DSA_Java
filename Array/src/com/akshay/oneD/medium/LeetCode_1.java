package com.akshay.oneD.medium;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1 {
	public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int rem;
        int[] res = {-1,-1};
        for(int i=0;i<n;i++){
            rem = target - nums[i];
            if(map.containsKey(rem)){
                res[0]=i;
                res[1]=map.get(rem);
                return res;
            }
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] arr = {3,2,4};
		int[] twoSum = twoSum(arr,6);
		System.out.println(twoSum[0] + " "+twoSum[1]);
	}
}
