package com.akshay.easy.sll;

import com.akshay.Node;

public class InsertAtKthPos {

	public static Node insertAtKthPos(Node head, int k, int val) {
		Node newNode = new Node(val);
		if (head == null) {
			return newNode;
		}

		if (k == 1) {
			head.next = newNode;
			return head;
		}
		Node temp = head;
		int cnt=1;
		while(temp != null) {
			cnt++;
			if(cnt == k) {
				newNode.next=temp.next;
				temp.next = newNode;
				break;
			}
			temp = temp.next;
		}
		
		return head;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		Node head = ArrayToSinglyLL.constructLinkedList(arr);
		Node newHead = insertAtKthPos(head, 3, 6);
		ArrayToSinglyLL.printSLL(newHead);
	}
}
