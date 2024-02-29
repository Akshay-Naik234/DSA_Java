package com.akshay.stack.imp;

public class NextSmallerElement {
	public static void immediateSmaller(int []a) {
        int n = a.length;
        for(int i=1;i<n;i++){
            if(a[i-1]>a[i]){
                a[i-1]=a[i];
            }
            else{
                a[i-1]=-1;
            }
        }
        a[n-1] = -1;
    }
	
	public static void main(String[] args) {
		int[] a = {4, 7, 8, 2, 3, 1};
		immediateSmaller(a);
		for (int i : a) {
			System.out.print(i + " ");
		}
	}
}
