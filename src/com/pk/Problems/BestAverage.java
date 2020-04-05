package com.pk.Problems;

import java.util.HashMap;

public class BestAverage {
	String scores[][] = new String[100][2];
	public void takeInputs() {
		scores[0][0] = "pk";
		scores[0][1] = "50";
		
		scores[1][0] = "pk";
		scores[1][1] = "70";
		
		scores[2][0] = "pk";
		scores[2][1] = "60";
		
		scores[3][0] = "jk";
		scores[3][1] = "50";
		
		scores[4][0] = "jk";
		scores[4][1] = "50";
		
		scores[5][0] = "jk";
		scores[5][1] = "50";
		
		
		for(int i=0; i<=5; i++) {
			System.out.println(scores[i][0] + " " + scores[i][1]);
		}
		
		
	}
	
	public int findBestAvg() {
		HashMap<String, Integer> marks = new HashMap<>();
		HashMap<String, Integer> cnt = new HashMap<>();
		
		for(int i=0; i<=5; i++) {
			if(marks.containsKey(scores[i][0])) {
				marks.put(scores[i][0], marks.get(scores[i][0]) + Integer.parseInt(scores[i][1]));
				cnt.put(scores[i][0], cnt.get(scores[i][0]) + 1);
			}else {
				marks.put(scores[i][0], Integer.parseInt(scores[i][1]));
				cnt.put(scores[i][0], 1);
			}
		}
		
		int maxavg = Integer.MIN_VALUE;
		for(String key : marks.keySet()) {
			int avg = marks.get(key) / cnt.get(key);
			
			if(avg > maxavg) {
				maxavg = avg;
			}
		}
		return maxavg;
	}
}
