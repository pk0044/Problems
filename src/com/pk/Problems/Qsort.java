package com.pk.Problems;

public class Qsort {
	int[] a;

	public Qsort(int size) {
		a = new int[size];
		a[0] = 100;
		a[1] = 5;
		a[2] = 0;
		a[3] = 6;
		a[4] = -1;
	}

	private void swap(int A, int B) {
		int temp = a[A];
		a[A] = a[B];
		a[B] = temp;
	}
	
	private int getPartition(int start, int end) {
		int index = start;
		for(int i=start; i < end; i++) {
			if(a[i] < a[end]) {
				swap(i, index);
				index++;
			}
			
		}
		
		swap(index, end);
		
		return index;
	}
	
	public void qsort(int start, int end) {
		if(start < end) {
			int p = getPartition(start, end);
			
			qsort(start, p-1);
			qsort(p+1, end);
		}
	}
	
	public void display() {
		for(int i=0; i<5; i++) {
			System.out.println(a[i]);
		}
	}

}
