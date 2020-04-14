package com.pk.Problems;

public class SmallestSub {
	int[] a = {2, 3, 1, 5, 6, 3, 7, 9, 14, 10, 2, 5};
	int k = 35;
	
	int start = 0;
	int end = 0;
	int minStart = -1;
	int minEnd = -1;
	int max = Integer.MAX_VALUE;
	
	public void findSmallestSubArray() {
		int sum = 0;
		int index = 0;
		start = 0;
		while(index < a.length) {

			sum = sum + a[index];
			
			if(sum >= k) {
				
				end = index;
				
				while(sum >= k) {
					sum = sum - a[start];
					start = start + 1;
					
					if(sum >= k) {
						if((end - start + 1) < max) {
							max = end - start + 1;
							minStart = start;
							minEnd = end;
						}
					}else {
						break;
					}
					
					start = start + 1;
				}
			}
			
			index = index + 1;
		}
		
		for(int i = minStart; i<= minEnd; i++) {
			System.out.println(a[i]);
		}
	}
}
