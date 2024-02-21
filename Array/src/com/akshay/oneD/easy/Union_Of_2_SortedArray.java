package com.akshay.oneD.easy;

import java.util.*;

public class Union_Of_2_SortedArray {

	public static List< Integer > sortedArray(int []a, int []b) {
        int n = a.length;
        int m = b.length;
        int i=0;
        int j=0;
        List<Integer> temp = new ArrayList<>();
        while(i<n && j<m){
            if(a[i]<=b[j]){
                if(temp.size() == 0 || temp.get(temp.size()-1) != a[i]){
                    temp.add(a[i]);
                }
                i++;
            }else{
                if(temp.size() == 0 || temp.get(temp.size()-1) != b[j]){
                    temp.add(b[j]);
                }
                j++;
            }
        }
        while(i<n){
            if(temp.size() == 0 || temp.get(temp.size()-1) != a[i]){
                    temp.add(a[i]);
            }
            i++;
        }
        while(j<m){
            if(temp.size() == 0 || temp.get(temp.size()-1) != b[j]){
                    temp.add(b[j]);
            }
                j++;
        }
        return temp;
    }
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 6};
		int[] b = {2, 3, 5};
		List<Integer> unionArray = sortedArray(a, b);
		for(int i=0;i<unionArray.size();i++) {
			System.out.print(unionArray.get(i) + " ");
		}
	}
}
