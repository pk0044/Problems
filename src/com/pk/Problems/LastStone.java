package com.pk.Problems;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * There is a collection of stones each time we take two stones of maximum wait and clash them if both have
 * equal wait both the stones destroyed else stone with smaller wait destroys and other stones wait decreased
 * by the stones of lighter stones
 * 
 *  continue this process until the last stone remains
 *  find the weight of the last stone
 *  
 *  Example :
 *  
 *  Input [5 4 3]
 *  
 *  
 *  step 1 : 5 X 4 = 1 => [3 1]
 *  step 2 " 3 X 1 = 2 => [2]
 *  
 *  Output 2
 *  
 * @author pk0044
 *
 */

public class LastStone {
	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(20, Collections.reverseOrder());
	
	int a = 0;
	int b = 0;
	
	public int getLastStones() {
		int[] stones = {4,5,67,9,34,23,6,87,65,70};
		
		for(int i=0; i<stones.length; i++) {
			pq.add(stones[i]);
		}
		
		while(!pq.isEmpty()) {
			a = pq.poll();
			
			if()
		}
	}
}
