package com.akshay.string.easy;

public class LeetCode_796 {
	public static boolean rotateString(String s, String goal) {
        if(s.length() !=goal.length()){
            return false;
        }
        String res=s;
        for(int i=0;i<s.length();i++){
            char ch = res.charAt(0);
            res = res.substring(1)+ch;
            if(res.equals(goal)){
                return true;
            }
        }
        return false;
    }
	public static void main(String[] args) {
		boolean res = rotateString("abcde", "cdeab");
		System.out.println(res);
	}
}
