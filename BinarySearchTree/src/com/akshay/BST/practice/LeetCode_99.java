package com.akshay.BST.practice;

public class LeetCode_99 {
	TreeNode first = null;
	TreeNode middle = null;
	TreeNode last = null;
	TreeNode prev = new TreeNode(Integer.MIN_VALUE);

	public void recover(TreeNode root) {
		if (root == null) {
			return;
		}
		recover(root.left);
		if (prev != null && root.val < prev.val) {
			if (first == null) {
				first = prev;
				middle = root;
			} else {
				last = root;
			}
		}
		prev = root;
		recover(root.right);
	}

	public void recoverTree(TreeNode root) {
		recover(root);
		if (first != null && last != null) {
			int t = first.val;
			first.val = last.val;
			last.val = t;
		} else if (first != null && middle != null) {
			int t = first.val;
			first.val = middle.val;
			middle.val = t;
		}
	}
}
