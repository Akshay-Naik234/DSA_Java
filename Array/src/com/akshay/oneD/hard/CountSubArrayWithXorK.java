package com.akshay.oneD.hard;

import java.util.*;

public class CountSubArrayWithXorK {
	public static int subarraysWithSumK(int []a, int b) {
        Map<Integer,Integer> map = new HashMap<>();
        int xr=0;
        map.put(0,1);
        int x;
        int count =0;
        for(int i=0;i<a.length;i++){
            xr = xr^a[i];
            x = xr^b;
            if(map.containsKey(x)){
                count += map.get(x);
            }
            if(map.containsKey(xr)){
                map.put(xr,map.get(xr)+1);
            }
            else{
                map.put(xr,1);
            }
        }
       return count; 
    }
	
	public static void main(String[] args) {
		int [] a = {1, 2, 3, 2};
		int b =2;
		int k = subarraysWithSumK(a,b);
		System.out.println(k);
	}
}
