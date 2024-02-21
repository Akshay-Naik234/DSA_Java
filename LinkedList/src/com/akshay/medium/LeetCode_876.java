package com.akshay.medium;

import com.akshay.Node;
import com.akshay.easy.sll.ArrayToSinglyLL;

public class LeetCode_876 {
	public static Node middleNode(Node head) {
		Node low = head;
		Node high = head;
        while(high !=null && high.next !=null){
            low = low.next;
            high = high.next.next;
        }
        return low;
    }
	
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		Node head = ArrayToSinglyLL.constructLinkedList(arr);
		Node node = middleNode(head);
		ArrayToSinglyLL.printSLL(node);
	}
}
