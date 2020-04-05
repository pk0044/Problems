package com.pk.Problems;

public class NumberOfSteps {
	/**
	 * recursive approach to reach the nth steps of the stairs
	 * allowed steps - 1 / 2 / 3
	 * @param n
	 * @return
	 */
	public int findTotalSteps(int n) {
		if(n == 0 || n == 1) {
			return 1;
		}
		
		if(n == 2) {
			return 2;
		}
		
		return findTotalSteps(n - 1) + findTotalSteps(n - 2) + findTotalSteps(n - 3); 
	}
	
	
	/**
	 * dynamic approach to reach the nth steps of the stair
	 * @param n
	 * @return
	 */
	public int findSteps(int n) {
		int a[] = new int [n+1];
		a[0] = 1;
		a[1] = 1;
		a[2] = 2;
		
		for(int i=3; i <= n; i++) {
			a[i] = a[i-1] + a[i-2] + a[i-3];
		}
		
		return a[n];
	}
}
