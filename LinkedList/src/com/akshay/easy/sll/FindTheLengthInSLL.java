package com.akshay.easy.sll;

import com.akshay.Node;

public class FindTheLengthInSLL {
	public static int length(Node head) {
		Node temp = head;
		int length = 0;
		if (head == null) {
			return 0;
		}
		while (temp != null) {
			temp = temp.next;
			length++;
		}
		return length;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		Node head = ArrayToSinglyLL.constructLinkedList(arr);
		int length = length(head);
		System.out.println(length);
	}
}
