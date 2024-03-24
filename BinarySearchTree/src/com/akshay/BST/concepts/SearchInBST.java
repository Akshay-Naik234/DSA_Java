package com.akshay.BST.concepts;

public class SearchInBST {
	public TreeNode searchBST(TreeNode root, int val) {
        if(root.val == val){
            return root;
        }
        while(root!=null && root.val != val){
            if(root.val>val){
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return root;
    }
}
	