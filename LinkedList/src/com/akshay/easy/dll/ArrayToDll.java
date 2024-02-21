package com.akshay.easy.dll;

public class ArrayToDll {
	
	public static Node constructDLL(int []arr) {
        Node head = new Node(arr[0],null,null);
        Node temp = head;
        for(int i=1;i<arr.length;i++){
            Node newNode = new Node(arr[i],null,temp);
            temp.next = newNode;
            temp=temp.next;
        }
        return head;
   }
	
	public static void printAll(Node head) {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data + " ");
			temp=temp.next;
		}
	}
	
	
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		Node head = constructDLL(arr);
		printAll(head);
	}

}
