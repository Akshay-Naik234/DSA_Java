package com.akshay.string.easy;

public class LeetCode_14 {
	public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for(int i=1;i<strs.length;i++){
            int j=0;
            String nums = strs[i];
            while(j<prefix.length() && j<nums.length() && prefix.charAt(j) == nums.charAt(j)){
                j++;
            }
            if(j==0){
                return "";
            }
            prefix = prefix.substring(0,j);
        }
        return prefix;
    }
	
	public static void main(String[] args) {
		String[] strs = {"flower","flow","flight"};
		String res = longestCommonPrefix(strs);
		System.out.println(res);
	}
}
