package com.akshay.oneD.hard;

public class LeetCode_152 {
	public static int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(prefix == 0){
                prefix=1;
            }
            if(suffix == 0){
                suffix=1;
            }
            prefix *=nums[i];
            suffix *=nums[n-i-1];
            ans = Math.max(ans,Math.max(prefix, suffix));
        }
        return ans;
    }
	
	public static void main(String[] args) {
		int maxProduct = maxProduct(new int[] {2,3,-2,4});
		System.out.println(maxProduct);
	}
}
