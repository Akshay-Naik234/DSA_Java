package com.akshay.BST.practice;

public class FloorInBST {
	public static int Floor(TreeNode node, int input) {	
		int floor = -1;
        while(node!=null){
            if(input>node.val){
				floor = node.val;
                node = node.right;
            }
            else if(input<node.val){
                node = node.left;
            }
            else if(input==node.val){
                return input;
            }
        }
        return floor;
	}
}
