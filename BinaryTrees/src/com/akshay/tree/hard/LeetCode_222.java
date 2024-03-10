package com.akshay.tree.hard;

public class LeetCode_222 {
	public int leftHeight(TreeNode root) {
		int cnt = 0;
		while (root != null) {
			root = root.left;
			cnt++;
		}
		return cnt;
	}

	public int rightHeight(TreeNode root) {
		int cnt = 0;
		while (root != null) {
			root = root.right;
			cnt++;
		}
		return cnt;
	}

	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		int left = leftHeight(root);
		int right = rightHeight(root);

		if (left == right) {
			return (1 << left) - 1;
		}
		int leftNodes = countNodes(root.left);
		int rightNodes = countNodes(root.right);
		return leftNodes + rightNodes + 1;
	}
}
