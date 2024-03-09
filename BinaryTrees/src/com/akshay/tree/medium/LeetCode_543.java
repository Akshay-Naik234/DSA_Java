package com.akshay.tree.medium;

public class LeetCode_543 {
	public int findDiameter(TreeNode root, int[] d) {
		if (root == null) {
			return 0;
		}
		int left = findDiameter(root.left, d);
		int right = findDiameter(root.right, d);
		d[0] = Math.max(d[0], left + right);
		return 1 + Math.max(left, right);
	}

	public int diameterOfBinaryTree(TreeNode root) {
		int[] d = { 0 };
		findDiameter(root, d);
		return d[0];
	}
}
