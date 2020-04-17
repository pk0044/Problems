package com.pk.Problems;

import java.util.List;

/**
 * Leetcode problem to find the sky line
 * 
 * proble link : https://leetcode.com/problems/the-skyline-problem/ 
 * 
 * Li Ri Hi
 * [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ]
 * 
 * @author pk0044
 *
 */

public class SkyLine {
	
	int[] sTree = new int [10000];
	
	private void createSegmentTree(int[][] buildings) {
		for(int i=0; i<buildings.length; i++) {
			sTree[buildings[i][0]] = buildings[i][2];
			sTree[buildings[i][1]] = buildings[i][2];
		}
		
		
	}
	
    public List<List<Integer>> getSkyline(int[][] buildings) {
    	
		return null;
    }
}
