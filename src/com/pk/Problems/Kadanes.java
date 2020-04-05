package com.pk.Problems;

import java.util.ArrayList;

public class Kadanes {
	private ArrayList<Integer> A = new ArrayList<Integer>();
	private Integer v;
	
	private void getInput() {
		A.add(-1);
		A.add(-2);
		A.add(-3);
		A.add(-4);

	}
	public void run() {
		getInput();
		Integer max = 0;
		int current_sum = 0;
		for(int i=0; i<A.size(); i++) {
			current_sum = current_sum + A.get(i);
			if(current_sum > max) {
				max = current_sum;
			}
			if(current_sum < 0) {
				current_sum = 0;
			}
		}
		System.out.println("Maximum sum subArray is : " + max);
	}
}
