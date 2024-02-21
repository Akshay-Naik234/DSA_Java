package com.akshay.easy.sll;

import com.akshay.Node;

public class InsertAtBeginingSLL {
	public static Node insertAtFirst(Node list, int newValue) {
        Node newNode = new Node(newValue);
        newNode.next = list;
        return newNode;
    }
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		Node head = ArrayToSinglyLL.constructLinkedList(arr);
		Node newHead = insertAtFirst(head,6);
		ArrayToSinglyLL.printSLL(newHead);
	}
}
