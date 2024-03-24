package com.akshay.medium;

public class LeetCode_930 {
	public static int numSubarraysWithSum(int[] nums, int goal) {
        return subArraySumAtMostK(nums,goal) - subArraySumAtMostK(nums,goal-1);
    }

    public static int subArraySumAtMostK(int[] nums,int goal){
        int start = 0;
        int ans = 0;
        int sum = 0;
        for(int end = 0;end<nums.length;end++){
            sum +=nums[end];
            while(sum>goal && start<=end){
                sum-=nums[start];
                start++;
            }
            ans += end -start+1;
        }
        return ans;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1,0,1,0,1};
		int res = numSubarraysWithSum(nums, 2);
		System.out.println(res);
		
	}
}
