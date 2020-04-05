package com.pk.Problems;

import java.util.LinkedList;
import java.util.Queue;

public class Queues {
	private Queue<Integer> Q = new LinkedList<>();
	public void runMethod() {
		Q.add(10);
		Q.add(9);
		Q.add(8);
		Q.add(7);
		Q.add(6);
		
		int a = Q.remove();
		System.out.println(a);
	}
}
