package com.akshay.tree.traversals;

import java.util.*;

public class LeetCode_144 {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode peek = s.pop();
			res.add(peek.data);
			if (peek.right != null) {
				s.push(peek.right);
			}
			if (peek.left != null) {
				s.push(peek.left);
			}
		}
		return res;
	}
}
