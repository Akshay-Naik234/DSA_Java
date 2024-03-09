package com.akshay.tree.medium;

import java.util.*;

import com.akshay.tree.medium.TopViewOfBT.Pair;

public class BottomViewOfBT {
	static class Pair {
		int point;
		TreeNode node;

		Pair(int point, TreeNode node) {
			this.point = point;
			this.node = node;
		}
	}

	public ArrayList<Integer> bottomView(TreeNode root) {
		Map<Integer, Integer> map = new TreeMap<>();
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, root));
		while (!q.isEmpty()) {
			Pair poll = q.remove();
			int point = poll.point;
			TreeNode temp = poll.node;

			map.put(point, temp.data);

			if (temp.left != null) {
				q.add(new Pair(point - 1, temp.left));
			}

			if (temp.right != null) {
				q.add(new Pair(point + 1, temp.right));
			}
		}
		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
			res.add(m.getValue());
		}
		return res;
	}
}
