package com.akshay.basic;

public class Question_6 {
	public static int setBits(int N){
        int pos = 0;
        boolean flag =false;
        int temp = N;
        while(N>0){
            if((N & 1) == 0){
            	pos++;
                flag= true;
                break;
            }
            pos++;
            N = N>>1;
        }
        return flag==true ? (temp | (1<<(pos-1))) : temp;
    }
	
	public static void main(String[] args) {
		int setBits = setBits(10);
		System.out.println(setBits);
	}
}
