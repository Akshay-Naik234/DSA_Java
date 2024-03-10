package com.akshay.BST.practice;

public class LeetCode_450 {
	public TreeNode findRightLast(TreeNode node) {
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}

	public TreeNode helper(TreeNode node) {
		if (node.left == null) {
			return node.right;
		}
		if (node.right == null) {
			return node.left;
		}
		TreeNode right = node.right;
		TreeNode rightLast = findRightLast(node.left);
		rightLast.right = right;
		return node.left;
	}

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}
		if (root.val == key) {
			return helper(root);
		}
		TreeNode dummy = root;
		while (root != null) {
			if (root.val > key) {
				if (root.left != null && root.left.val == key) {
					root.left = helper(root.left);
					break;
				} else {
					root = root.left;
				}
			}

			else {
				if (root.right != null && root.right.val == key) {
					root.right = helper(root.right);
					break;
				} else {
					root = root.right;
				}
			}

		}
		return dummy;
	}
}
