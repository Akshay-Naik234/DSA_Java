package com.akshay.easy.dll;

public class ReverseDll {
	public static Node reverseDLL(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node last = null;
		Node cur = head;
		while (cur != null) {
			last = cur.prev;
			cur.prev = cur.next;
			cur.next = last;
			cur = cur.prev;
		}
		return last.prev;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		Node head = ArrayToDll.constructDLL(arr);
		Node newHead = reverseDLL(head);
		ArrayToDll.printAll(newHead);
	}
}
