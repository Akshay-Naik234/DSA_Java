package com.akshay.easy.sll;

import com.akshay.Node;

public class DeleteValueAtSll {

	public static Node deleteValue(Node head, int val) {
		if (head == null) {
			return head;
		}
		if (head.data == val) {
			return head.next;
		}
		Node temp = head;
		Node prev = null;
		while (temp != null) {
			if (temp.data == val) {
				prev.next = prev.next.next;
				break;
			}
			prev = temp;
			temp = temp.next;
		}
		return head;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		Node head = ArrayToSinglyLL.constructLinkedList(arr);
		Node newHead = deleteValue(head, 3);
		ArrayToSinglyLL.printSLL(newHead);
	}
}
