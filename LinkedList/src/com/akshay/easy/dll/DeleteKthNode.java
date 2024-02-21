package com.akshay.easy.dll;

public class DeleteKthNode {
	public static Node deleteKthNode(Node head, int k) {

		if (head == null) {
			return null;
		}
		if (k == 1) {
			Node tmp = head;
			head = head.next;
			tmp.next = null;
			return head;
		}
		Node temp = head;
		Node prev;
		int cnt = 0;
		while (temp.next != null) {
			cnt++;
			if (cnt == k) {
				prev = temp.prev;
				prev.next = temp.next;
				temp.next.prev = prev;
				break;
			}
			temp = temp.next;
		}
		cnt++;
		if (cnt == k) {
			temp.prev.next = null;
		}

		return head;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		Node head = ArrayToDll.constructDLL(arr);
		Node newHead = deleteKthNode(head, 6);
		ArrayToDll.printAll(newHead);
	}
}
