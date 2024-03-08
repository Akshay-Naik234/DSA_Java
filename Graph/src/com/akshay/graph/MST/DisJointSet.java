package com.akshay.graph.MST;

import java.util.ArrayList;
import java.util.List;

public class DisJointSet {

	List<Integer> rank = new ArrayList<>();
	List<Integer> parent = new ArrayList<>();
	List<Integer> size = new ArrayList<>();

	public DisJointSet(int n) {
		for (int i = 0; i <= n; i++) {
			rank.add(0);
			parent.add(i);
			size.add(1);
		}
	}

	public int getUParent(int node) {
		if (node == parent.get(node)) {
			return node;
		}
		int uParent = getUParent(parent.get(node));
		parent.set(node, uParent);
		return parent.get(node);
	}

	public void unionByRank(int u, int v) {
		int uParent = getUParent(u);
		int vParent = getUParent(v);
		if (uParent == vParent) {
			return;
		}
		if (rank.get(uParent) < rank.get(vParent)) {
			parent.set(uParent, vParent);
		} else if (rank.get(vParent) < rank.get(uParent)) {
			parent.set(vParent, uParent);
		} else {
			parent.set(vParent, uParent);
			rank.set(uParent, rank.get(uParent) + 1);
		}
	}
	
	public void unionBySize(int u,int v) {
		int uParent = getUParent(u);
		int vParent = getUParent(v);
		if (uParent == vParent) {
			return;
		}
		if(size.get(uParent)<size.get(vParent)) {
			parent.set(uParent, vParent);
			size.set(vParent, size.get(uParent)+size.get(vParent));
		}
		else {
			parent.set(vParent, uParent);
			size.set(uParent, size.get(uParent)+size.get(vParent));
		}
		
	}

}
