package com.pk.Problems;

import java.util.ArrayList;

public class Heaps {
	
	private int size;
	private ArrayList<Integer> heap;
	
	public void swap(int a, int b) {
		int temp = heap.get(a);
		heap.set(a, heap.get(b));
		heap.set(b, temp);
	}
	
	public void insert(int data) {
		
		if(heap == null) {
			heap = new ArrayList<Integer>();
		}
		
		if(heap.size() == size) {
			System.out.println("data cant be inserted. size limit exceeded !!");
			return;
		}
		
		heap.add(data);
		
		while(true) {
			
		}
	}
}
