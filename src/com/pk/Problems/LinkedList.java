package com.pk.Problems;

import java.util.ArrayList;

import com.pk.nodes.NodeL;

public class LinkedList {
	
	NodeL head;
	
	
	
	/**
	 * function to reverse a linked list in a group of K
	 * @param data
	 */
	
	public void reversList(int K) {
		NodeL one = null;
		NodeL two = null;
		NodeL three = null;
		
		
		NodeL start1 = null;
		NodeL end1 = null;
		NodeL start2 = null;
		NodeL end2 = null;
		
		int count = 0;
		
		if(head != null) {
			one = head;
			end1 = head;
			count++;
		}
		
		if(head.getNext() != null) {
			two = head.getNext();
		}
		
		
		while(one != null && two != null) {
			
			three = two.getNext();
			
			if(count % K != 0) {
				two.setNext(one);
			}
			
			one = two;
			two = three;
			count++;
			
			
			if(count == K) {
				start1 = one;
				end2 = two;
			}else if(count % K == 0) {
				end1.setNext(one);
				end1 = end2;
				end2 = two;
			}
			
		}
		
		end1.setNext(one);
		end2.setNext(null);
		
		head = start1;
	}
	
	
	public void insert(int data) {
		
		NodeL curr = new NodeL(data);
		
		if(head == null) {
			head = curr;
			return;
		}
		
		NodeL temp;
		temp = head;
		
		while(temp.getNext() != null) {
			temp = temp.getNext();
		}
		
		temp.setNext(curr);
	}
	


	public void setHead(NodeL head) {
		this.head = head;
	}

	public void display() {
		if(head == null) {
			System.out.println("linked list is empty !!");
			return;
		}
		
		NodeL temp;
		temp = head;
		
		while(temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}
	
	public void reverseDiplay(NodeL heads) {
		if(heads != null) {
			reverseDiplay(heads.getNext());
			System.out.println(heads.getData());
		}
	}

	public NodeL getHead() {
		return head;
	}
	
	/**
	 * recurstive function to print the linked list in reverse order.
	 * 
	 */
	
	public void printReverse(NodeL head) {
		if(head == null) {
			return;
		}
		
		printReverse(head.getNext());
		
		System.out.println(head.getData());
	}
	
	
	/**
	 * recursive function to check if a list is a palindrome.
	 */
	
	
	public NodeL checkPalindrome(NodeL A, NodeL B) {
		if(B == null) {
			return null;
		}
		return B;
	}
	
	/**
	 * recursive function to reverse a linked list
	 * 
	 */
	
	public NodeL reverseLinkedList(NodeL head) {
		if(head.getNext() == null) {
			return head;
		}
		NodeL next = head.getNext();
		NodeL newHead = reverseLinkedList(head.getNext());
		next.setNext(head);
		return newHead;
	}
}
