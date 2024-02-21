package com.akshay.medium;

import com.akshay.Node;
import com.akshay.easy.sll.ArrayToSinglyLL;

public class Sort012 {

	public static Node sortList(Node head) {

		Node zeroDummy = new Node(0);
		Node oneDummy = new Node(0);
		Node twoDummy = new Node(0);

		Node zero = zeroDummy;
		Node one = oneDummy;
		Node two = twoDummy;

		Node temp = head;
		while (temp != null) {
			if (temp.data == 0) {
				zero.next = temp;
				zero = zero.next;
			} else if (temp.data == 1) {
				one.next = temp;
				one = one.next;
			} else if (temp.data == 2) {
				two.next = temp;
				two = two.next;
			}
			temp = temp.next;
		}
		zero.next = oneDummy.next != null ? oneDummy.next : twoDummy.next;
		one.next = twoDummy.next;
		two.next = null;
		return zeroDummy.next;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 0, 2, 1, 0, 2, 1 };
		Node head = ArrayToSinglyLL.constructLinkedList(arr);
		Node node = sortList(head);
		ArrayToSinglyLL.printSLL(node);
	}
}
