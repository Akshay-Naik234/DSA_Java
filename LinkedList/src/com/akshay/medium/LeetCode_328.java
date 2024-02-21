package com.akshay.medium;

import com.akshay.Node;
import com.akshay.easy.sll.ArrayToSinglyLL;

public class LeetCode_328 {
	public static Node oddEvenList(Node head) {

		if (head == null || head.next == null) {
			return head;
		}

		Node Odd = head;
		Node even = head.next;
		Node evenHead = head.next;
		while (even != null && even.next != null) {
			Odd.next = Odd.next.next;
			even.next = even.next.next;
			Odd = Odd.next;
			even = even.next;
		}
		Odd.next = evenHead;
		return head;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		Node head = ArrayToSinglyLL.constructLinkedList(arr);
		Node node = oddEvenList(head);
		ArrayToSinglyLL.printSLL(node);
	}
}
