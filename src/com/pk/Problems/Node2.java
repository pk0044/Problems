package com.pk.Problems;

public class Node2{
	int data;
	int nodePoolIndex;
	Node2 left;
	Node2 right;
	
	public Node2(int data) {
		this.data = data;
		this.nodePoolIndex = -1;
		this.left = null;
		this.right = null;
	}
}