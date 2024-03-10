package com.akshay.tree.hard;

import java.util.*;

public class LeetCode_863 {

	public void markParent(TreeNode root, HashMap<TreeNode, TreeNode> parent) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			if (node.left != null) {
				parent.put(node.left, node);
				q.add(node.left);
			}
			if (node.right != null) {
				parent.put(node.right, node);
				q.add(node.right);
			}
		}
	}

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		HashMap<TreeNode, TreeNode> parent = new HashMap<>();
		markParent(root, parent);
		List<Integer> res = new ArrayList<>();
		HashMap<TreeNode, Boolean> visited = new HashMap<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(target);
		visited.put(target, true);
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			if (cnt++ == k) {
				break;
			}

			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node.left != null && !visited.containsKey(node.left)) {
					visited.put(node.left, true);
					q.add(node.left);
				}
				if (node.right != null && !visited.containsKey(node.right)) {
					visited.put(node.right, true);
					q.add(node.right);
				}
				if (parent.containsKey(node) && !visited.containsKey(parent.get(node))) {
					visited.put(parent.get(node), true);
					q.add(parent.get(node));
				}
			}
		}
		while (!q.isEmpty()) {
			TreeNode current = q.poll();
			res.add(current.val);
		}
		return res;
	}
}
