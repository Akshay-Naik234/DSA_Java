package com.akshay.tree.hard;

import java.util.*;
import java.util.Map.Entry;

public class LeetCode_2385 {
	public static TreeNode markParent(TreeNode root, HashMap<TreeNode, TreeNode> parent, int start) {
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode res = new TreeNode(-1);
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode node = q.poll();

			if (node.val == start) {
				res = node;
			}

			if (node.left != null) {
				parent.put(node.left, node);
				q.add(node.left);
			}
			if (node.right != null) {
				parent.put(node.right, node);
				q.add(node.right);
			}
		}
		return res;
	}

	public static int amountOfTime(TreeNode root, int start) {
		HashMap<TreeNode, TreeNode> parent = new HashMap<>();
		TreeNode target = markParent(root, parent, start);
		HashMap<TreeNode, Boolean> visited = new HashMap<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(target);
		visited.put(target, true);
		int ans = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			boolean flag = false;
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node.left != null && !visited.containsKey(node.left)) {
					flag = true;
					visited.put(node.left, true);
					q.add(node.left);
				}
				if (node.right != null && !visited.containsKey(node.right)) {
					flag = true;
					visited.put(node.right, true);
					q.add(node.right);
				}
				if (parent.containsKey(node) && !visited.containsKey(parent.get(node))) {
					flag = true;
					visited.put(parent.get(node), true);
					q.add(parent.get(node));
				}
			}
			if (flag == true) {
				ans++;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(5);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(9);
		root.left.right.right = new TreeNode(2);

		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(6);
		int res = amountOfTime(root, 3);
		System.out.println(res);

	}
}
