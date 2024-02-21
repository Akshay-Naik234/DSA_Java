package com.akshay.easy.dll;

public class DeleteNodeOfDll {
	private static void deleteNodeOfDll(Node temp) {

		Node prev = temp.prev;
		Node front = temp.next;
		if (front == null) {
			prev.next = null;
			temp.prev = null;
		}
		prev.next = front;
		front.prev = prev;
		temp.next = null;
		temp.prev = null;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		Node head = ArrayToDll.constructDLL(arr);
		deleteNodeOfDll(head);
	}

}
