package com.akshay.basic;

public class Question_3 {
	public static String oddEven(int N){
        return (N & 1)>0 ? "odd" : "even";
    }
	
	public static void main(String[] args) {
		System.out.println(oddEven(6));
	}
}
