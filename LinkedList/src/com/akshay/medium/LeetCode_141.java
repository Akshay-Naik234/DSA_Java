package com.akshay.medium;

import com.akshay.Node;
import com.akshay.easy.sll.ArrayToSinglyLL;

public class LeetCode_141 {
	public static boolean hasCycle(Node head) {
		Node slow = head;
		Node fast = head;
        while(fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5};
		Node head = ArrayToSinglyLL.constructLinkedList(arr);
		boolean result = hasCycle(head);
		System.out.println(result);
	}
}
