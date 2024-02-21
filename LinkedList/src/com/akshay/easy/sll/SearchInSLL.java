package com.akshay.easy.sll;

import com.akshay.Node;

public class SearchInSLL {
	public static int searchInLinkedList(Node head, int k) {
		if (head == null) {
			return 0;
		}
		Node temp = head;
		while (temp != null) {
			if (temp.data == k) {
				return 1;
			}
			temp = temp.next;
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		Node head = ArrayToSinglyLL.constructLinkedList(arr);
		int result = searchInLinkedList(head, 5);
		System.out.println(result);
	}
}
