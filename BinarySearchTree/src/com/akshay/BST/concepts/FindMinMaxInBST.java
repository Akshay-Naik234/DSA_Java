package com.akshay.BST.concepts;

public class FindMinMaxInBST {
	public static int minValue(TreeNode root) {
        if(root == null){
            return -1;
        }
        while(root.left != null){
            root = root.left;
        }
        return root.val;
    }
	
	public static int maxValue(TreeNode root) {
        if(root == null){
            return -1;
        }
        while(root.right != null){
            root = root.right;
        }
        return root.val;
    }
}
