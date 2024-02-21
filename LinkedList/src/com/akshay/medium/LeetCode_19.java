package com.akshay.medium;

import com.akshay.Node;
import com.akshay.easy.sll.ArrayToSinglyLL;

public class LeetCode_19 {
	public static Node removeNthFromEnd(Node head, int n) {
		Node slow = head;
		Node fast = head;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		if (fast == null) {
			return head.next;
		}
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		Node delNode = slow.next;
		slow.next = slow.next.next;
		delNode = null;
		return head;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 2, 0, -4 };
		Node head = ArrayToSinglyLL.constructLinkedList(arr);
		Node node = removeNthFromEnd(head,2);
		ArrayToSinglyLL.printSLL(node);
	}
}
