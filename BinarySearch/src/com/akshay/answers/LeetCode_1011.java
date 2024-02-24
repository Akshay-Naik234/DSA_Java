package com.akshay.answers;

public class LeetCode_1011 {
	public static int arraySum(int[] weights){
        int sum =0;
        for(int i=0;i<weights.length;i++){
            sum+=weights[i];
        }
        return sum;
    }

    public static int func(int[] weights,int mid){
        int sum = 0;
        int cnt = 1;
        for(int i=0;i<weights.length;i++){
        	if(sum + weights[i]>mid) {
        		cnt++;
        		sum = weights[i];
        	}else {
        		sum += weights[i];
        	}
        }
        return cnt;
    }
    
    public static int findMax(int[] weights) {
    	int max = weights[0];
    	for(int i=1;i<weights.length;i++) {
    		if(weights[i]>max) {
    			max = weights[i];
    		}
    	}
    	return max;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int low = findMax(weights);
        int high = arraySum(weights);
        int mid;
        int ans = -1;
        while(low<=high){
            mid = (low+high)/2;
            int cnt = func(weights,mid);
            if(cnt > days){
                low = mid+1;
            }
            else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
		int[] weights = {1,2,3,1,1};
		int days = 4;
		int shipWithinDays = shipWithinDays(weights, days);
		System.out.println(shipWithinDays);
	}
}
