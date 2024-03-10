package com.akshay.tree.hard;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_297 {
	public String serialize(TreeNode root) {
		StringBuilder res = new StringBuilder();
		if (root == null) {
			return " ";
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node == null) {
				res.append("n ");
				continue;
			}
			res.append(node.val + " ");
			q.add(node.left);
			q.add(node.right);
		}
		return res.toString();
	}

	public TreeNode deserialize(String data) {
		if (data.trim() == "") {
			return null;
		}
		String[] values = data.split(" ");
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode root = new TreeNode(Integer.parseInt(values[0]));
		q.add(root);
		while (!q.isEmpty()) {
			for (int i = 1; i < values.length; i++) {
				TreeNode node = q.poll();
				if (!values[i].equals("n")) {
					TreeNode left = new TreeNode(Integer.parseInt(values[i]));
					node.left = left;
					q.add(left);
				}
				if (!values[++i].equals("n")) {
					TreeNode right = new TreeNode(Integer.parseInt(values[i]));
					node.right = right;
					q.add(right);
				}
			}
		}
		return root;
	}
}
