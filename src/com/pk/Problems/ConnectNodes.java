package com.pk.Problems;

import java.util.Queue;
import java.util.LinkedList;

public class ConnectNodes {
	
	private class Node{
		int data;
		Node left;
		Node right;
		Node next;
		
		public Node(int X) {
			data = X;
		}
	}
	
	Node root;
	
	public void construct() {
		root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(10);
		
		root.left.left = new Node(0);
		root.left.right = new Node(4);
		
		root.right.right = new Node(15);
		
		root.right.left = new Node(8);
		
		connect(root);
	}
	
	
    public void connect(Node p)
    {
    	Queue<Node> Q = new LinkedList<>();
    	Node head;
    	if(p != null) {
    		head = p;
    	}else {
    		return;
    	}
    	
    	if(head.left != null) {
    		Q.add(head.left);
    	}
    	
    	if(head.right != null) {
    		Q.add(head.right);
    	}
    	
    	Node temp = head;
    	
    	while(!Q.isEmpty()) {
    		
    		temp.next = Q.poll();
    		temp = temp.next;
    		
    		if(temp != null) {
        		if(temp.left != null) {
        			Q.add(temp.left);
        		}
        		
        		if(temp.right != null) {
        			Q.add(temp.right);
        		}
    		}

    	}
    	
    	display(head);
    }
    
    private void display(Node head) {
    	Node temp = head;
    	
    	while(head != null) {
    		System.out.println(head.data);
    		head = head.next;
    	}
    }
}
