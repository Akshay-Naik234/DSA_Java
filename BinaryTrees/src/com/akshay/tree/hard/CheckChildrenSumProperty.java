package com.akshay.tree.hard;

public class CheckChildrenSumProperty {
	public static int isSumProperty(Node root) {
		int sum = 0;
		if (root == null || (root.left == null && root.right == null)) {
			return 1;
		} else {
			if (root.left != null) {
				sum += root.left.data;
			}
			if (root.right != null) {
				sum += root.right.data;
			}
			if (root.data == sum && isSumProperty(root.left) != 0 && isSumProperty(root.right) != 0) {
				return 1;
			} else {
				return 0;
			}
		}
	}
}
