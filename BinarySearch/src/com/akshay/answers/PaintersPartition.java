package com.akshay.answers;

import java.util.ArrayList;

public class PaintersPartition {
	public static int findMax(ArrayList<Integer> arr) {
		int mini = arr.get(0);
		for (int i = 1; i < arr.size(); i++) {
			if (arr.get(i) > mini) {
				mini = arr.get(i);
			}
		}
		return mini;
	}

	public static int findSum(ArrayList<Integer> arr) {
		int sum = 0;
		for (int i = 0; i < arr.size(); i++) {
			sum += arr.get(i);
		}
		return sum;
	}

	public static boolean func(ArrayList<Integer> arr, int n, int m, int mid) {
		int sum = 0;
		int cnt = 1;
		for (int i = 0; i < n; i++) {
			if (sum + arr.get(i) > mid) {
				cnt++;
				sum = arr.get(i);
			} else {
				sum = sum + arr.get(i);
			}
		}
		if (cnt <= m) {
			return true;
		}
		return false;
	}

	public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
		int n = boards.size();
		if (k > n)
			return -1;
		int low = findMax(boards);
		int high = findSum(boards);
		int mid;
		int ans = -1;
		while (low <= high) {
			mid = (low + high) / 2;
			boolean res = func(boards, n, k, mid);
			if (res) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(1);
		list.add(5);
		list.add(6);
		list.add(2);
		list.add(3);
		System.out.println(findLargestMinDistance(list, 2));
	}
//	2, 1, 5, 6, 2, 3
}
