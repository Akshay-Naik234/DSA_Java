package com.akshay.tree.hard;

import java.util.*;

public class LeetCode_106 {
	public TreeNode buildTree(int[] postorder, int[] inorder, int postStart, int postEnd, int inStart, int inEnd,
			HashMap<Integer, Integer> map) {
		if (postStart > postEnd || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[postEnd]);
		int inRoot = map.get(root.val);
		int numsLeft = inRoot - inStart;
		root.left = buildTree(postorder, inorder, postStart, postStart + numsLeft - 1, inStart, inRoot - 1, map);
		root.right = buildTree(postorder, inorder, postStart + numsLeft, postEnd - 1, inRoot + 1, inEnd, map);
		return root;
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int inLength = inorder.length;
		int postLength = postorder.length;
		for (int i = 0; i < inLength; i++) {
			map.put(inorder[i], i);
		}
		return buildTree(postorder, inorder, 0, postLength - 1, 0, inLength - 1, map);
	}
}
