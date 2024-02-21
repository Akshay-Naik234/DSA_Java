package com.akshay.medium;

import com.akshay.Node;
import com.akshay.easy.sll.ArrayToSinglyLL;

public class LeetCode_160 {
	public static int findDifference(Node node1, Node node2) {
		int cnt1 = 0;
		int cnt2 = 0;
		while (node1 != null || node2 != null) {
			if (node1 != null) {
				cnt1++;
				node1 = node1.next;
			}
			if (node2 != null) {
				cnt2++;
				node2 = node2.next;
			}
		}
		return cnt1 - cnt2;
	}

	public static Node getIntersectionNode(Node headA, Node headB) {
		int diff = findDifference(headA, headB);
		if (diff < 0) {
			while (diff != 0) {
				headB = headB.next;
				diff++;
			}
		} else if (diff > 0) {
			while (diff != 0) {
				headA = headA.next;
				diff--;
			}
		}
		while (headA != null) {
			if (headA == headB) {
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}
	
	public static void main(String[] args) {
		int[] arr = {4,1,8,4,5 };
		int[] arr1 = {5,6,1,8,4,5};
		Node head1 = ArrayToSinglyLL.constructLinkedList(arr);
		Node head2 = ArrayToSinglyLL.constructLinkedList(arr1);
		Node node = getIntersectionNode(head1,head2);
		System.out.println(node);
	}
}
