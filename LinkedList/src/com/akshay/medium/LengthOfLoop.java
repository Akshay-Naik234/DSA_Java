package com.akshay.medium;

import com.akshay.Node;
import com.akshay.easy.sll.ArrayToSinglyLL;

public class LengthOfLoop {
	public static int findLength(Node slow,Node fast){
        int cnt=1;
        fast = fast.next;
        while(slow!=fast){
            cnt++;
            fast=fast.next;
        }
        return cnt;
    }

    public static int lengthOfLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return findLength(slow,fast);
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
		int[] arr = { 4, 10, 3, 5 };
		Node head = ArrayToSinglyLL.constructLinkedList(arr);
		ArrayToSinglyLL.createCycle(head,1);
		int n = lengthOfLoop(head);
		System.out.println(n);
	}
}
