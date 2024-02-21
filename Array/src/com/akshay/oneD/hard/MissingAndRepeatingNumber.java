package com.akshay.oneD.hard;

public class MissingAndRepeatingNumber {
	public static int[] findMissingRepeatingNumbers(int []a) {
        int[] res = new int[2];
        long n = a.length;
        long sn = (n*(n+1))/2;
        long sn2 = (n*(n+1) * (2*n+1))/6;
        long sn1 = 0;
        long sn21 = 0;
        for(int i=0;i<n;i++){
            sn1+=a[i];
            sn21+=a[i]*a[i];
        }
        long val1 = sn-sn1;
        long val2 = sn2-sn21;
        val2 = val2/val1;
        long x = (val1 + val2)/2;
        long y = (x-val1);
        res[0] = (int)y;
        res[1] = (int)x;
        return res;
    }
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 2};
		int[] res = findMissingRepeatingNumbers(a);
		System.out.println(res[0] + " "+res[1]);
	}
}
