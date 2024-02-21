package com.akshay.easy.dll;

public class InsertBeforeTailDll {

	public static Node insertBeforeTail(Node head, int val) {
		Node newNode = new Node(val, null, null);
		if (head == null) {
			return newNode;
		}
		if (head.next == null) {
			head.prev = newNode;
			newNode.next = head;
			return newNode;
		}
		Node temp = head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		newNode.next = temp.next;
		temp.next.prev = newNode;
		temp.next = newNode;
		newNode.prev = temp;
		return head;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		Node head = ArrayToDll.constructDLL(arr);
		Node newHead = insertBeforeTail(head, 6);
		ArrayToDll.printAll(newHead);
	}
}
