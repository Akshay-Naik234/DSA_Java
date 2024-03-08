package com.akshay.graph.MST;

import java.util.HashMap;
import java.util.Map.Entry;

public class LeetCode_947 {
	public static int removeStones(int[][] stones) {
		int maxRow = 0;
		int maxCol = 0;
		for(int[] stone:stones) {
			maxRow = Math.max(maxRow, stone[0]);
			maxCol = Math.max(maxCol, stone[1]);
		}
		DisJointSet ds = new DisJointSet(maxRow+maxCol+1);
		HashMap<Integer, Integer> stoneNodes = new HashMap<>();
		for(int[] s : stones) {
			int row = s[0];
			int col = s[1]+maxRow+1;
			ds.unionByRank(row, col);
			stoneNodes.put(row, 1);
			stoneNodes.put(col, 1);
		}
		int cnt = 0;
		for(Entry<Integer,Integer> it: stoneNodes.entrySet()) {
			if(ds.getUParent(it.getKey()) == it.getKey()) {
				cnt++;
			}
		}
		return stones.length-cnt;
	}
	
	 public static void main (String[] args) {
	        int[][] stones = {
	            {0, 0}, {0, 2},
	            {1, 3}, {3, 1},
	            {3, 2}, {4, 3}
	        };

	        int ans = removeStones(stones);
	        System.out.println("The maximum number of stones we can remove is: " + ans);
	    }
}
