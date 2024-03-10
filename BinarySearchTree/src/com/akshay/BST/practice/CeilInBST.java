package com.akshay.BST.practice;

public class CeilInBST {
	public static int findCeil(TreeNode node, int x) {
		int ceil = -1;
		while (node != null) {
			if (x > node.val) {
				node = node.right;
			} else if (x < node.val) {
				ceil = node.val;
				node = node.left;
			} else if (x == node.val) {
				return x;
			}
		}
		return ceil;

	}
}
