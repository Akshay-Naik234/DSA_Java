package com.akshay.oneD.hard;

public class LeetCode_88 {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[i+j+1]=nums1[i];
                i--;
            }
            else{
                nums1[i+j+1]=nums2[j];
                j--;
            }
        }
        while(j>=0){
            nums1[i+j+1]=nums2[j];
            j--;
        }
    }
	
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,0,0,0};
		int m = 3;
		int[] nums2 = {2,5,6};
		int n = 3;
		merge(nums1, m, nums2, n);
		for(int i=0;i<nums1.length;i++) {
			System.out.print(nums1[i] + " ");
		}
	}
}
