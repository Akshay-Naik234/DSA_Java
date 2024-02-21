package com.akshay.easy.sll;

import com.akshay.Node;

public class ArrayToSinglyLL {

	public static Node constructLinkedList(int[] arr) {
		Node head = new Node(arr[0]);
		Node temp = head;
		for (int i = 1; i < arr.length; i++) {
			Node newNode = new Node(arr[i]);
			temp.next = newNode;
			temp = temp.next;
		}
		return head;
	}

	public static void printSLL(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}

	public static void createCycle(Node head, int pos) {
		Node ptr = head;
		Node temp = head;
		int cnt = 0;
		while (temp.next != null) {
			if (cnt != pos) {
				++cnt;
				ptr = ptr.next;
			}
			temp = temp.next;
		}
		temp.next = ptr;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		Node head = constructLinkedList(arr);
		printSLL(head);
	}
}
