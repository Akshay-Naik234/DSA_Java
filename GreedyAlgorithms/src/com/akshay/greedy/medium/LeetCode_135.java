package com.akshay.greedy.medium;

import java.util.Arrays;

public class LeetCode_135 {
	public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] ans = new int[n];
        Arrays.fill(ans,1);
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                ans[i] = ans[i-1]+1;
            }
        }
        for(int i=n-1;i>0;i--){
            if(ratings[i]<ratings[i-1] && ans[i]>=ans[i-1]){
                ans[i-1] = ans[i]+1;
            }
        }
        return Arrays.stream(ans).sum();
    }
	public static void main(String[] args) {
		int[] ratings = {1,0,2};
		int res = candy(ratings);
		System.out.println(res);
	}
}
