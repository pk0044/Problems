package com.pk.Problems;

public class StringProblem {
	private String s;
	
	/**
	 * find the largest substring without repeating characters
	 * @return
	 */
	
	private void resetMap(int[] maps) {
		for(int i=0; i<26; i++) {
			maps[i] = 0;
		}
	}
	
	public int findLargetsSubStr() {
		int[] maps;
		maps = new int[26];
		int l = 0;
		resetMap(maps);
		int max = 0;
		
		for(int i=0; i<s.length(); i++) {
			int index = s.charAt(i) - 'a';
			if(maps[index] == 0) {
				l++;
				maps[index] = 1;
			}else {
				if(l > max) {
					max = l;
				}
				
				resetMap(maps);
				maps[index] = 1;
				l = 1;
			}
		}
		
		return max;
	}
	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
}
