package com.akshay.BST.practice;

public class LeetCode_230 {
	public TreeNode kthSmall(TreeNode root, int[] k){
        if(root == null){
            return null;
        }
        TreeNode left = kthSmall(root.left,k);
        if(left !=null){
            return left;
        }
        k[0]--;
        if(k[0]==0)
	        return root;
        return kthSmall(root.right,k);
    }

    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return -1;
        }
        int[] p ={k};
        TreeNode node = kthSmall(root,p);
        if(node == null){
            return -1;
        }
        return node.val;
    }
}
