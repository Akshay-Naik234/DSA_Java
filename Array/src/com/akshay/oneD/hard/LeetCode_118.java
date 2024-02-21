package com.akshay.oneD.hard;
import java.util.*;

public class LeetCode_118 {
	public static int nCr(int n,int r){
        int res=1;
        for(int i=0;i<r;i++){
            res = res * (n-i);
            res = res/(i+1);
        }
        return (int) res;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=1;j<=i;j++){
                temp.add(nCr(i-1,j-1));
            }
            res.add(temp);
        }
        return res;
    }
    
    public static void main(String[] args) {
    	List<List<Integer>> generate = generate(5);
    	for (List<Integer> list : generate) {
			System.out.println(list.toString());
		}
	}
}
