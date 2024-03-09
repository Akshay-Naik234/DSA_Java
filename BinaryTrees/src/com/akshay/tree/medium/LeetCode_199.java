package com.akshay.tree.medium;

import java.util.*;

public class LeetCode_199 {
	public void rightView(TreeNode root, List<Integer> res, int cnt) {
		if (root == null) {
			return;
		}
		if (res.size() == cnt) {
			res.add(root.data);
		}
		rightView(root.right, res, cnt + 1);
		rightView(root.left, res, cnt + 1);
	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		rightView(root, res, 0);
		return res;
	}
}
