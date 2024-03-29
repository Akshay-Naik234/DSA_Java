package com.akshay.tree.medium;

public class LeetCode_110 {
	public int dfsHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = dfsHeight(root.left);
		if (left == -1) {
			return -1;
		}
		int right = dfsHeight(root.right);
		if (right == -1) {
			return -1;
		}
		if (Math.abs(left - right) > 1) {
			return -1;
		}
		return 1 + Math.max(left, right);
	}

	public boolean isBalanced(TreeNode root) {
		if (dfsHeight(root) == -1) {
			return false;
		}
		return true;
	}
}
