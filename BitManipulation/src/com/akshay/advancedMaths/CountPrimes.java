package com.akshay.advancedMaths;

import java.util.*;

public class CountPrimes {
	
	public static boolean isPrime(int n){
        for(int i= 2;i<n;i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
    public static List< Integer > countPrimes(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=2;i<=n/2;i++){
            if(n%i == 0 && isPrime(i)){
                res.add(i);
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		List<Integer> countPrimes = countPrimes(44);
		System.out.println(countPrimes);
	}
}
