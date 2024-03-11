package com.akshay.BST.practice;

import java.util.Stack;

public class BSTIterator {
	private Stack<TreeNode> s = new Stack<TreeNode>();

	public void pushAll(TreeNode root) {
		TreeNode curr = root;
		while (curr != null) {
			s.push(curr);
			curr = curr.left;
		}
	}

	public BSTIterator(TreeNode root) {
		pushAll(root);
	}

	public int next() {
		if (hasNext()) {
			TreeNode node = s.pop();
			int result = node.val;
			if (node.right != null) {
				pushAll(node.right);
			}
			return result;
		}
		return -1;
	}

	public boolean hasNext() {
		return !s.isEmpty();
	}
}
