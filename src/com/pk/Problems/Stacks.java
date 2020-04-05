package com.pk.Problems;

import java.util.Iterator;
import java.util.Stack;

public class Stacks {
	private Stack<Integer> stack = new Stack<Integer>();
	public void runMethod() {
		stack.add(10);
		stack.add(9);
		stack.add(8);
		stack.add(7);
		stack.add(60);
		
	//	int a = stack.pop();
		
	//	System.out.println(a);
	}
	
	
	private void deleteMiddleHelper(int mid, int count) {
		if(count < mid - 1) {
			int num = stack.pop();
			count++;
			deleteMiddleHelper(mid, count);
			stack.add(num);
		}else {
			stack.pop();
			count++;
			return;
		}
	}
	
	public void deleteMiddle(int N) {
		int mid = N % 2 == 0 ? N / 2 : (N / 2) + 1;
		deleteMiddleHelper(mid, 0);
	}
	
	public void display() {
		Iterator value = stack.iterator();
		
		while(value.hasNext()) {
			System.out.println(value.next());
		}
	}
}
