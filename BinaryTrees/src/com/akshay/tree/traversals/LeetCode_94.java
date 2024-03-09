package com.akshay.tree.traversals;

import java.util.*;

public class LeetCode_94 {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        while(true){
            if(root != null){
                s.push(root);
                root = root.left;
            }
            else{
                if(s.isEmpty()){
                    break;
                }
                root = s.peek();
                res.add(s.pop().data);
                root = root.right;
            }
        }
        return res;
    }
}
