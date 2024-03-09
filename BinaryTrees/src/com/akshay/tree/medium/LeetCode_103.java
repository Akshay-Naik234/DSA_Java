package com.akshay.tree.medium;

import java.util.*;

public class LeetCode_103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> q = new LinkedList<>();
		boolean leftToRight = true;
		q.add(root);
		while (!q.isEmpty()) {
			List<Integer> temp = new ArrayList<>();
			int level = q.size();
			for (int i = 0; i < level; i++) {
				TreeNode node = q.poll();
				if (leftToRight == true) {
					temp.add(node.data);
				} else {
					temp.add(0, node.data);
				}
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}
			}
			res.add(temp);
			leftToRight = !leftToRight;
		}
		return res;
	}
}
