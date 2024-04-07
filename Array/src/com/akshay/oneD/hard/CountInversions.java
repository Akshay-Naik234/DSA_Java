package com.akshay.oneD.hard;

import java.util.ArrayList;

public class CountInversions {
	
	public static int merge(int[] a,int low,int mid,int high) {
		ArrayList<Integer> temp = new ArrayList<>();
		int left = low;
		int right = mid+1;
		int cnt=0;
		while(left<=mid && right<=high) {
			if(a[left]<=a[right]) {
				temp.add(a[left]);
				left++;
			}else {
				temp.add(a[right]);
				cnt+=mid-left+1;
				right++;
			}
		}
		while(left<=mid) {
			temp.add(a[left]);
			left++;
		}
		while(right<=high) {
			temp.add(a[right]);
			right++;
		}
		for(int i=low;i<=high;i++) {
			a[i] = temp.get(i-low);
		}
		return cnt;
	}
	
	public static int mergeSort(int[] a,int low,int high) {
		int cnt=0;
		if(low>=high) {
			return cnt;
		}
		int mid = (low+high)/2;
		cnt+=mergeSort(a, low, mid);
		cnt+=mergeSort(a, mid+1, high);
		cnt+=merge(a,low,mid,high);
		return cnt;
	}
	
	public static void main(String[] args) {
		int[] a = {5, 4, 3, 2, 1};
        int n = 5;
        int cnt = mergeSort(a, 0, n - 1);
        System.out.println("The number of inversions are: " + cnt);
	}
}
