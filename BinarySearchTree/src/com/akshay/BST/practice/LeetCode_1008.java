package com.akshay.BST.practice;

public class LeetCode_1008 {
	public TreeNode bstPreorder(int[] preorder,int bound,int[] a){
        if(a[0] == preorder.length || preorder[a[0]] >= bound){
            return null;
        }
        TreeNode root = new TreeNode(preorder[a[0]++]);
        root.left = bstPreorder(preorder,root.val,a);
        root.right = bstPreorder(preorder,bound,a);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int[] a = {0};
        return bstPreorder(preorder,Integer.MAX_VALUE,a);
    }
}
