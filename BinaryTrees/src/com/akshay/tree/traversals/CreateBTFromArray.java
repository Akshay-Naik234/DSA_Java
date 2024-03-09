package com.akshay.tree.traversals;

public class CreateBTFromArray {
	public static Node createTree(int[] arr) {
		return createBinaryTree(arr, 0);
	}

	static Node createBinaryTree(int[] arr, int i) {
		Node node = null;
		if (i < arr.length) {
			node = new Node(arr[i]);
			node.left = createBinaryTree(arr, 2 * i + 1);
			node.right = createBinaryTree(arr, 2 * i + 2);
		}
		return node;
	}

	public static void main(String[] args) {
		int[] arr = { 11, 22, 3, 54, 15, 23, 21 };
		Node node = createTree(arr);
		System.out.println(node.data);
	}
}
