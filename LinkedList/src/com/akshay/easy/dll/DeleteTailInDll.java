package com.akshay.easy.dll;

public class DeleteTailInDll {
	
	private static Node deleteTail(Node head) {
		if (head == null || head.next == null) {
			return null;
		}
		Node temp = head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next.prev = null;
		temp.next = null;
		return head;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		Node head = ArrayToDll.constructDLL(arr);
		Node newHead = deleteTail(head);
		ArrayToDll.printAll(newHead);
	}
}
