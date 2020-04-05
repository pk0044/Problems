package com.pk.Problems;



public class Heap2 {
	Node2 root;
	int heapSize;
	int MAX;
	Node2[] nodePools;
	
	public Heap2(int maxSize) {
		this.root = null;
		this.MAX = maxSize;
		this.nodePools = new Node2[MAX];
		this.heapSize = 0;
	}

	
	public Node2 getNode(int data) {
		return new Node2(data);
	}
	
	
	/**
	 * function to heapify nodePools
	 */
	
	private void heapifyNodes() {
		Node2 node = nodePools[0];
		int parentIndex = 0;
		int maxIndex = parentIndex;
		while(true) {
			int leftChildIndex = getLeftChild(parentIndex);
			int rightChildIndex = getRightChild(parentIndex);
			
			if(leftChildIndex != -1 && nodePools[parentIndex].data < nodePools[leftChildIndex].data) {
				swap(leftChildIndex, parentIndex);
				maxIndex =leftChildIndex;
			}
			
			if(rightChildIndex != -1 && nodePools[rightChildIndex].data > nodePools[maxIndex].data) {
				swap(rightChildIndex, maxIndex);
				maxIndex = rightChildIndex;
			}
			
			if(maxIndex == parentIndex) {
				break;
			}
			
			parentIndex = maxIndex;
		}
		
	}
	
	/**
	 * function to get the parent of any node
	 */
	
	private int getParent(int index) {
		if((index-1)/2 >= 0) {
			return (index-1) / 2;
		}
		return -1;
	}
	
	/**
	 * function to swap two nodes in nodePools
	 */
	
	private void swap(int A, int B) {
		Node2 temp = this.nodePools[A];
		this.nodePools[A] = this.nodePools[B];
		nodePools[B] = temp;
	}
	
	/**
	 * function to insert a node in Heap
	 */
	
	public int insert(Node2 node) {
		System.out.println("insert :: " + node.data);
		int res;
		Node2 currentNode = node;
		if(this.root == null) {
			this.root = node;
			this.nodePools[0] = node;
			this.heapSize++;
			res = 1; 
		}else if(this.heapSize < this.MAX) {
			this.nodePools[heapSize] = node;
			currentNode = node;
			int currentIndex = heapSize;
			int parentIndex = getParent(heapSize);
			while(parentIndex != -1){
				Node2 parent = this.nodePools[parentIndex];
				if(parent.data < currentNode.data) {
					swap(currentIndex, parentIndex);
					currentIndex = parentIndex;
					currentNode = nodePools[currentIndex];
					parentIndex = getParent(currentIndex);
				}else {
					break;
				}
			}
			this.heapSize++;
			res = 1;;
		}else {
			System.out.println("heap size limit exceeded!!");
			res = -1;
		}
		return res;
	}
	
	/**
	 * function to get the Right child node
	 */

	private int getRightChild(int parentIndex) {
		if((2 * parentIndex + 2) < this.heapSize) {
			return (2 * parentIndex) + 2;
		}
		return -1;
	}
	
	/**
	 * function to get the Left child node
	 */
	
	private int getLeftChild(int parentIndex) {
		if((2 * parentIndex) + 1 < this.heapSize) {
			return 2 * parentIndex + 1;
		}
		return -1;
	}
	
	/**
	 * function to pop Max Node from nodePools 
	 */
	
	public Node2 popMax() {
		if(this.heapSize == 0) {
			System.out.println("popmax root is null");
			return null;
			
		}
		System.out.println("pop max :: " + this.nodePools[0].data);
		swap(0, heapSize-1);
		this.heapSize--;
		heapifyNodes();
		return root;
	}
}
