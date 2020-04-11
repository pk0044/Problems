package com.pk.Problems;

public class SlidingWindow {
	int a[] = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
	
	int first = 0;
	int second = 0;
	int max = 0;
	
	public void findMaxWindow(int k) {
		int p = 0;
		int q = k - 1;
		int t = p;
		max = a[q];
		
		int i = 0;
		
		while(q < a.length) {
			if(a[p] > max) {
				max = a[p];
			}
			
			i++;
			p++;
			
			if(q == p && p != a.length) {
				System.out.println(max);
				q++;
				p = ++t;
				
				if(q < a.length) {
					max = a[q];
				}
			}
		}
		
		System.out.println("#### " + i);
	}
}
