package com.pk.nodes;

public class NodeL {
	private int data;
	NodeL next;
	
	public NodeL(int data) {
		this.data = data;
		this.next = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public NodeL getNext() {
		return next;
	}

	public void setNext(NodeL next) {
		this.next = next;
	}
}