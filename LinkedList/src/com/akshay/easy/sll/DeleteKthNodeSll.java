package com.akshay.easy.sll;

import com.akshay.Node;

public class DeleteKthNodeSll {

	public static Node deleteKthNode(Node head, int k) {
		if (head == null) {
			return head;
		}
		if (k == 1) {
			head = head.next;
			return head;
		}
		Node temp = head;
		Node prev = null;
		int counter = 0;
		while (temp != null) {
			counter++;
			if (counter == k) {
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
		Node newHead = deleteKthNode(head, 3);
		ArrayToSinglyLL.printSLL(newHead);
	}
}
