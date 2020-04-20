package com.pk.Problems;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class ConstructBSTFromPreOrder {
	
	private class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	
    public TreeNode bstFromPreorder(int[] preorder) {
    	TreeNode root = null;
    	int size = preorder.length;
    	if(size == 0) {
    		return root;
    	}
    	
    	Stack<TreeNode> st = new Stack<TreeNode>();
    	TreeNode temp;
    	TreeNode child;
    	temp = new TreeNode(preorder[0]);
    	root = temp;
    	st.push(temp);
    	
    	for(int i=1; i<preorder.length; i++) {
    		
    		child = new TreeNode(preorder[i]);
    		
    		if(st.peek().val > preorder[i]) {
    			st.peek().left = child;
    		}else {
    			while(!st.empty() && st.peek().val < preorder[i]) {
    				temp = st.pop();
    			}
    			
				if(temp.val < preorder[i]) {
					temp.right = child;
				}

    			if(st.isEmpty()) {
    				temp.right = child;
    			}
    		}
    		
    		st.push(child);
    	}
        return root;
    }
}
