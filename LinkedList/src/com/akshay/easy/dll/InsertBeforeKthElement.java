package com.akshay.easy.dll;

public class InsertBeforeKthElement {

	private static Node insertBeforeKthElement(Node head, int k, int val) {
		Node newNode = new Node(val, null, null);
		if (head == null) {
			return newNode;
		}
		if (k == 1) {
			newNode.next = head.prev;
			return newNode;
		}
		int cnt = 1;
		Node temp = head;
		while (temp.next != null) {
			cnt++;
			if (cnt == k) {
				newNode.next = temp.next;
				temp.next.prev = newNode;
				temp.next = newNode;
				newNode.prev = temp;
				break;
			}
			temp = temp.next;
		}
		cnt++;
		if (cnt == k) {
			temp.next = newNode;
		}
		return head;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		Node head = ArrayToDll.constructDLL(arr);
		Node newHead = insertBeforeKthElement(head, 6, 7);
		ArrayToDll.printAll(newHead);
	}

}
