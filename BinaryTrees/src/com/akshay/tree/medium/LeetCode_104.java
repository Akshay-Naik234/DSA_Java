package com.akshay.tree.medium;

public class LeetCode_104 {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return 1 + Math.max(left, right);
	}
}
