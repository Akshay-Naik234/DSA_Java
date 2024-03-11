package com.akshay.BST.practice;

import java.util.Stack;

public class LeetCode_653 {
	class BSTIterator {
		Stack<TreeNode> s = new Stack<TreeNode>();
		boolean reverse = true;

		public void pushAll(TreeNode root) {
			while (root != null) {
				s.push(root);
				if (reverse == true) {
					root = root.right;
				} else {
					root = root.left;
				}
			}
		}

		public int next() {
			TreeNode node = s.pop();
			if (reverse == true) {
				pushAll(node.left);
			} else {
				pushAll(node.right);
			}
			return node.val;
		}

		BSTIterator(TreeNode root, boolean isReversed) {
			reverse = isReversed;
			pushAll(root);
		}
	}

	public boolean findTarget(TreeNode root, int k) {
		BSTIterator l = new BSTIterator(root, false);
		BSTIterator r = new BSTIterator(root, true);
		int i = l.next();
		int j = r.next();
		while (i < j) {
			if (i + j == k) {
				return true;
			} else if (i + j < k) {
				i = l.next();
			} else {
				j = r.next();
			}
		}
		return false;
	}
}
