package com.akshay.medium;

import com.akshay.Node;
import com.akshay.easy.sll.ArrayToSinglyLL;

public class LeetCode_142 {

	public static Node detectCycle(Node head) {
		if (head == null || head.next == null) {
			return null;
		}

		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		if (slow != fast) {
			return null;
		}
		fast = head;
		while (slow.data != fast.data) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		int[] arr = { 3,2,0,-4 };
		Node head = ArrayToSinglyLL.constructLinkedList(arr);
	    ArrayToSinglyLL.createCycle(head, 1);
		Node node = detectCycle(head);
		System.out.println(node.data);
	}
}
