package com.akshay.easy.sll;

import com.akshay.Node;

public class DeleteLastNodeInSLL {
	public static Node deleteLast(Node list){
        Node temp = list;
        if(temp == null || temp.next == null){
            return null;
        }
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next= null;
        return list;
    }
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		Node head = ArrayToSinglyLL.constructLinkedList(arr);
		Node newHead = deleteLast(head);
		ArrayToSinglyLL.printSLL(newHead);
	}
}
