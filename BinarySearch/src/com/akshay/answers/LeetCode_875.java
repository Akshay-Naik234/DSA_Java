package com.akshay.answers;

public class LeetCode_875 {
	public static int func(int[] piles,int h,int mid){
        int totalHours = 0;
        for(int i=0;i<piles.length;i++){
        	totalHours += Math.ceil((double)(piles[i]) / (double)(mid));
        }
        return totalHours;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low =1;
        int high = findMax(piles);
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            int totalHours = func(piles,h,mid);
            if (totalHours <= h) {
            	ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

	private static int findMax(int[] piles) {
		int max = piles[0];
		for(int i =1;i<piles.length;i++) {
			if(piles[i]>max) {
				max = piles[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr = {3,6,7,11};
		int h = 8;
		int minEatingSpeed = minEatingSpeed(arr,h);
		System.out.println(minEatingSpeed);
	}
}
