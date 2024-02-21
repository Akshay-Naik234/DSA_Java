package com.akshay.medium;

import com.akshay.Node;
import com.akshay.easy.sll.ArrayToSinglyLL;

public class LeetCode_2095 {
	public static Node deleteMiddle(Node head) {
		if (head == null || head.next == null) {
			return null;
		}
		Node slow = head;
		Node fast = head;
		fast = fast.next.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node delNode = slow.next;
		slow.next = slow.next.next;
		delNode = null;
		return head;
	}

	public static void main(String[] args) {
		int[] arr = { 3, 2, 5, 0, -4 };
		Node head = ArrayToSinglyLL.constructLinkedList(arr);
		Node node = deleteMiddle(head);
		ArrayToSinglyLL.printSLL(node);
	}
}
