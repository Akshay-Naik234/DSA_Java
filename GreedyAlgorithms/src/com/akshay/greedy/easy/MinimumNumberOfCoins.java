package com.akshay.greedy.easy;
import java.util.*;
public class MinimumNumberOfCoins {
	public static List<Integer> MinimumCoins(int n) {
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        List<Integer> res = new ArrayList<>();
        for(int i=coins.length-1;i>=0;i--){
            while(n>=coins[i]){
                n-=coins[i];
                res.add(coins[i]);
                if(n==0){
                    return res;
                }
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		List<Integer> res = MinimumCoins(13);
		System.out.println(res);
	}
}
