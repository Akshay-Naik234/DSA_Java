package com.akshay.tree.traversals;

import java.util.*;

public class LeetCode_102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		if (root == null) {
			return res;
		}
		q.add(root);
		while (!q.isEmpty()) {
			int level = q.size();
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < level; i++) {
				TreeNode node = q.poll();
				temp.add(node.data);
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}
			res.add(temp);
		}
		return res;
	}

}
