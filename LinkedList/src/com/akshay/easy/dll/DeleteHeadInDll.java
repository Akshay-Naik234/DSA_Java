package com.akshay.easy.dll;

public class DeleteHeadInDll {

	public static Node deleteHead(Node head) {
		if (head == null || head.next == null) {
			return null;
		}
		Node prev = head;
		head = head.next;
		head.prev = null;
		prev.next = null;
		return head;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		Node head = ArrayToDll.constructDLL(arr);
		Node newHead = deleteHead(head);
		ArrayToDll.printAll(newHead);
	}
}
