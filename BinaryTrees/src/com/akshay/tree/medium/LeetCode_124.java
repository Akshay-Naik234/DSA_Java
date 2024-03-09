package com.akshay.tree.medium;

public class LeetCode_124 {
	public int findSum(TreeNode root,int[] d){
        if(root == null){
            return 0;
        }
        int left = Math.max(0,findSum(root.left,d));
        int right = Math.max(0,findSum(root.right,d));
        d[0] = Math.max(d[0],left+right+root.data);
        return root.data + Math.max(left,right);
    }

    public int maxPathSum(TreeNode root) {
        int[] d = {Integer.MIN_VALUE};
        findSum(root,d);
        return d[0];
    }
}
