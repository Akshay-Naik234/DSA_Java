package com.akshay.tree.traversals;

import java.util.*;

public class TreeTraversals {
	public static List<Integer> inorder(TreeNode root, List<Integer> temp) {
		if (root == null) {
			return new ArrayList<>();
		}
		inorder(root.left, temp);
		temp.add(root.data);
		inorder(root.right, temp);
		return temp;
	}

	public static List<Integer> preorder(TreeNode root, List<Integer> temp) {
		if (root == null) {
			return new ArrayList<>();
		}
		temp.add(root.data);
		preorder(root.left, temp);
		preorder(root.right, temp);
		return temp;
	}

	public static List<Integer> postorder(TreeNode root, List<Integer> temp) {
		if (root == null) {
			return new ArrayList<>();
		}
		postorder(root.left, temp);
		postorder(root.right, temp);
		temp.add(root.data);
		return temp;
	}

	public static List<List<Integer>> getTreeTraversal(TreeNode root) {
		// Write your code here.
		List<List<Integer>> res = new ArrayList<>();
		res.add(inorder(root, new ArrayList<>()));
		res.add(preorder(root, new ArrayList<>()));
		res.add(postorder(root, new ArrayList<>()));
		return res;
	}
}
