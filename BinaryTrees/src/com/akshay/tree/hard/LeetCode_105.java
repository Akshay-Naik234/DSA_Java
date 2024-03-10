package com.akshay.tree.hard;

import java.util.*;

public class LeetCode_105 {
	public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd,
			HashMap<Integer, Integer> map) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);
		int inRoot = map.get(root.val);
		int numsLeft = inRoot - inStart;
		root.left = buildTree(preorder, inorder, preStart + 1, preStart + numsLeft, inStart, inRoot - 1, map);
		root.right = buildTree(preorder, inorder, preStart + numsLeft + 1, preEnd, inRoot + 1, inEnd, map);
		return root;
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int preLength = preorder.length;
		int inLength = inorder.length;
		for (int i = 0; i < inLength; i++) {
			map.put(inorder[i], i);
		}
		return buildTree(preorder, inorder, 0, preLength - 1, 0, inLength - 1, map);
	}
}
