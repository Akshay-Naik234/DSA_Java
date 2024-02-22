package com.akshay.OneD;

public class LeetCode_33 {
	public static int search(int[] nums, int target) {
        int low =0;
        int high = nums.length -1;
        int mid;
        while(low<=high){
            mid = (low+high)/2;

            if(nums[mid]==target){
                return mid;
            }

            if(nums[low]<=nums[mid]){
                if(nums[low]<= target && nums[mid] >= target){
                    high = mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            else {
            	if(nums[mid]<= target && nums[high] >= target){
                    low = mid+1;
                }
                else{
                    high = mid -1;
                }
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		int [] nums = {4,5,6,7,0,1,2};
		int search = search(nums, 0);
		System.out.println(search);
	}
}
