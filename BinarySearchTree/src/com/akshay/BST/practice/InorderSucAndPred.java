package com.akshay.BST.practice;

import java.util.*;

public class InorderSucAndPred {
	public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
		TreeNode successor = null;
		TreeNode predecessor = null;
		List<Integer> res = new ArrayList<>();
		TreeNode curr = root;
		while (root != null) {
			if (key > root.val) {
				predecessor = root;
				root = root.right;
			} else if (key <= root.val) {
				root = root.left;
			}
		}

		while (curr != null) {
			if (key >= curr.val) {
				curr = curr.right;
			} else if (key < curr.val) {
				successor = curr;
				curr = curr.left;
			}
		}
		if (predecessor == null) {
			res.add(-1);
		} else {
			res.add(predecessor.val);
		}

		if (successor == null) {
			res.add(-1);
		} else {
			res.add(successor.val);
		}

		return res;
	}
}
