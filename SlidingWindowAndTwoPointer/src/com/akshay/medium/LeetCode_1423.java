package com.akshay.medium;

public final class LeetCode_1423 {
	public static int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int left = k;
        int n = cardPoints.length;
        int right = n-1;
        for(int i=0;i<k;i++){
            sum+=cardPoints[i];
        }
        int ans = sum;
        while(left>0){
            sum-=cardPoints[--left];
            sum+=cardPoints[right--];
            ans = Math.max(ans,sum);
        }
        return ans;
    }
	
	public static void main(String[] args) {
		int[] cards = {1,2,3,4,5,6,1};
		int res = maxScore(cards, 3);
		System.out.println(res);
	}
}
