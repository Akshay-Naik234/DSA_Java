package com.akshay.easy.sll;

import com.akshay.Node;

public class InsertBeforeVal {

	public static Node insertBeforeValue(Node head, int el, int val) {
		Node newNode = new Node(val);
		if (head == null) {
			return null;
		}
		if (head.data == el) {
			newNode.next = head;
			return newNode;
		}
		Node temp = head;
		while (temp.next != null) {
			if (temp.next.data == el) {
				newNode.next = temp.next;
				temp.next = newNode;
				break;
			}
			temp = temp.next;
		}
		return head;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		Node head = ArrayToSinglyLL.constructLinkedList(arr);
		Node newHead = insertBeforeValue(head, 3, 6);
		ArrayToSinglyLL.printSLL(newHead);
	}
}
