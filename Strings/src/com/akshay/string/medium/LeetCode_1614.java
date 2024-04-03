package com.akshay.string.medium;

public class LeetCode_1614 {
	public static int maxDepth(String s) {
        int counter = 0;
        int maxi = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                counter ++;
                maxi = Math.max(maxi,counter);
            }
            else if(s.charAt(i) == ')'){
                counter--;
            }
        }
        return maxi;
    }
	public static void main(String[] args) {
		int res = maxDepth("(1)+((2))+(((3)))");
		System.out.println(res);
	}
}
