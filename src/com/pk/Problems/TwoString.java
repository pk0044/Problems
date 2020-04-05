package com.pk.Problems;

import java.util.HashMap;
import java.util.Map;

public class TwoString {
	
	public boolean checkString(String s1, String s2) {
		boolean res = true;
		Map<Character, Character> maps = new HashMap<>();
		int i = 0;
		
		while(i < s1.length()) {
			if(maps.containsKey(s1.charAt(i))) {
				if(maps.get(s1.charAt(i)) != s2.charAt(i)) {
					res = false;
					break;
				}
			}else {
				maps.put(s1.charAt(i), s2.charAt(i));
			}
			i++;
		}
		return res;
	}

}
