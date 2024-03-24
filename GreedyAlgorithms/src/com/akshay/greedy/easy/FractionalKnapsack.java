package com.akshay.greedy.easy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
	
	static class Item {
	    int value, weight;
	    Item(int x, int y){
	        this.value = x;
	        this.weight = y;
	    }
	}
	
	static class ItemComparator implements Comparator<Item>{

		@Override
		public int compare(Item a, Item b) {
			double r1 = (double)(a.value) / (double)(a.weight); 
            double r2 = (double)(b.value) / (double)(b.weight); 
            if(r1 < r2) return 1; 
            else if(r1 > r2) return -1; 
            else return 0; 
		}
		
	}
	
	static double fractionalKnapsack(int W, Item arr[], int n) 
    {
		ItemComparator comparator = new ItemComparator();
		Arrays.sort(arr,comparator);
		int curWeight =0;
		double maxi =0;
		for(Item item : arr) {
			if(curWeight+item.weight<=W) {
				curWeight +=item.weight;
				maxi +=item.value;
			}
			else {
				int remaining = W - curWeight;
				maxi +=((double)item.value / (double)item.weight) * (double)remaining;
				break;
			}
		}
		return maxi;
    }
	
	public static void main(String[] args) {
		int N = 3, W = 50;
		Item arr[] = {new Item (100,20),new Item(60,10),new Item(120,30)};
		double res = fractionalKnapsack(W, arr, N);
		System.out.println(res);
	}
}
