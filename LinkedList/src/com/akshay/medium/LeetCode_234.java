package com.akshay.medium;

import com.akshay.Node;
import com.akshay.easy.sll.ArrayToSinglyLL;

public class LeetCode_234 {
	public static Node reverse(Node head){
        if (head == null || head.next == null) {
			return head;
		}
        Node cur=head;
        Node prev = null;
        while(cur!=null){
        	Node next = cur.next;
            cur.next = prev;
            prev=cur;
            cur = next;
        }
        return prev;
    }

    public static boolean isPalindrome(Node head) {
        if(head == null || head.next == null){
            return true;
        }
        Node slow = head;
        Node fast = head;
        while(fast.next !=null && fast.next.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow.next !=null){
            Node newHead = reverse(slow.next);
            fast = newHead;
            slow = head;
            while(fast !=null){
                if(slow.data !=fast.data){
                    reverse(newHead);
                    return false;
                }
                slow = slow.next;
                fast = fast.next;
            }
            reverse(newHead);
            return true;
        }
        else{
            return false;
        }
    }
	
	public static void main(String[] args) {
		int[] arr = {1,2,2,1 };
		Node head = ArrayToSinglyLL.constructLinkedList(arr);
		boolean result= isPalindrome(head);
		System.out.println(result);
	}
}
