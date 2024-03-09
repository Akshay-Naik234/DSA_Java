package com.akshay.tree.medium;

public class LeetCode_101 {
	public boolean symmetricUtil(TreeNode node1, TreeNode node2) {
		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 == null || node2 == null) {
			return false;
		}

		return (node1.data == node2.data) && symmetricUtil(node1.left, node2.right)
				&& symmetricUtil(node1.right, node2.left);
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return symmetricUtil(root.left, root.right);
	}
}
