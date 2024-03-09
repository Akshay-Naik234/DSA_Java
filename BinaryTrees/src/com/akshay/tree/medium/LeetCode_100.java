package com.akshay.tree.medium;

public class LeetCode_100 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		return (p.data == q.data) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
