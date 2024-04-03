package com.akshay.medium;

import java.util.*;

public class FruitIntoBasckets {
	public static int findMaxFruits(int[] arr, int n) {
		if (arr == null || n == 0)
			return 0;

		int maxFruits = 0;
		int left = 0;
		Map<Integer, Integer> fruitMap = new HashMap<>();

		for (int right = 0; right < n; right++) {
			int fruit = arr[right];
			fruitMap.put(fruit, fruitMap.getOrDefault(fruit, 0) + 1);

			while (fruitMap.size() > 2) {
				int leftFruit = arr[left];
				fruitMap.put(leftFruit, fruitMap.get(leftFruit) - 1);
				if (fruitMap.get(leftFruit) == 0) {
					fruitMap.remove(leftFruit);
				}
				left++;
			}

			maxFruits = Math.max(maxFruits, right - left + 1);
		}

		return maxFruits;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 1, 2, 3};
		int res = findMaxFruits(arr, arr.length);
		System.out.println(res);
	}
}
