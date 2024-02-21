package com.akshay.medium;

import com.akshay.Node;
import com.akshay.easy.sll.ArrayToSinglyLL;

public class LeetCode_206 {
	public static Node reverseList(Node head) {
		Node prev = null;
        Node temp = head;
        while(temp != null){
        	Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
	
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		Node head = ArrayToSinglyLL.constructLinkedList(arr);
		Node node = reverseList(head);
		ArrayToSinglyLL.printSLL(node);
	}
}
