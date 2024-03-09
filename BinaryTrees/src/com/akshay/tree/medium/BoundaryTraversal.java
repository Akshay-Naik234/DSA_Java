package com.akshay.tree.medium;

import java.util.*;

public class BoundaryTraversal {
	public static boolean isLeaf(TreeNode root) {
		if (root.left == null && root.right == null) {
			return true;
		}
		return false;
	}

	static void leftBoundary(TreeNode root, ArrayList<Integer> res) {
		TreeNode cur = root.left;
		while (cur != null) {
			if (isLeaf(cur) == false)
				res.add(cur.data);
			if (cur.left != null)
				cur = cur.left;
			else
				cur = cur.right;
		}
	}

	static void rightBoundary(TreeNode root, ArrayList<Integer> res) {
		TreeNode cur = root.right;
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		while (cur != null) {
			if (isLeaf(cur) == false)
				tmp.add(cur.data);
			if (cur.right != null)
				cur = cur.right;
			else
				cur = cur.left;
		}
		int i;
		for (i = tmp.size() - 1; i >= 0; --i) {
			res.add(tmp.get(i));
		}
	}

	static void addLeaves(TreeNode root, ArrayList<Integer> res) {
		if (isLeaf(root)) {
			res.add(root.data);
			return;
		}
		if (root.left != null)
			addLeaves(root.left, res);
		if (root.right != null)
			addLeaves(root.right, res);
	}

	public static List<Integer> traverseBoundary(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (isLeaf(root) == false) {
			res.add(root.data);
		}
		leftBoundary(root, res);
		addLeaves(root, res);
		rightBoundary(root, res);
		return res;

	}
}
