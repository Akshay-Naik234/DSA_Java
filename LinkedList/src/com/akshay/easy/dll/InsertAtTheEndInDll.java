package com.akshay.easy.dll;

public class InsertAtTheEndInDll {

	public static Node insertAtTail(Node list, int K) {
		Node newNode = new Node(K, null, null);
		if (list == null) {
			return newNode;
		}
		if (K == 1) {
			list.prev = newNode;
			newNode.next = list;
			return newNode;
		}
		Node temp = list;
		while (temp.next != null) {
			temp = temp.next;
		}
		newNode.prev = temp;
		temp.next = newNode;
		return list;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		Node head = ArrayToDll.constructDLL(arr);
		Node newHead = insertAtTail(head, 6);
		ArrayToDll.printAll(newHead);
	}

}
