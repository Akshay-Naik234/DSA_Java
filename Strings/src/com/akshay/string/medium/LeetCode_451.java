package com.akshay.string.medium;

import java.util.*;

public class LeetCode_451 {
	public static String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list,(a,b) -> map.get(b) - map.get(a));
        StringBuilder res = new StringBuilder();
        for(char ch : list){
            int freq = map.get(ch);
            for(int i=0;i<freq;i++){
                res.append(ch);
            }
        }
        return res.toString();
    }
	
	public static void main(String[] args) {
		String res = frequencySort("tree");
		System.out.println(res);
	}
}
