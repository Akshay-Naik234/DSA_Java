package com.akshay.stack.imp;

import java.util.Stack;

public class LeetCode_735 {
	public static int[] asteroidCollision(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();

		for (int asteroid : asteroids) {
			if (asteroid > 0 || stack.isEmpty() || stack.peek() < 0) {
				stack.push(asteroid);
			} else {
				while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
					stack.pop();
				}
				if (!stack.isEmpty() && stack.peek() == -asteroid) {
					stack.pop();
				} else if (stack.isEmpty() || stack.peek() < 0) {
					stack.push(asteroid);
				}
			}
		}

		int[] result = new int[stack.size()];
		for (int i = result.length - 1; i >= 0; i--) {
			result[i] = stack.pop();
		}

		return result;
	}
	public static void main(String[] args) {
		int[] arr= {5,10,-5};
		int[] collision = asteroidCollision(arr);
		for (int i : collision) {
			System.out.print(i + " ");
		}
	}
}
