package com.pk.Problems;

public class Withoutloops {
	public void printPattern(int N, int dir, int current_number) {
		if(current_number <= N) {
			System.out.println(current_number);
		}
		if(dir == 0) {
			if(current_number <= 0) {
				printPattern(N, 1, current_number + 5);
			}else {
				printPattern(N, 0, current_number - 5);
			}
		}else {
			if(current_number <= N) {
				printPattern(N, 1, current_number + 5);
			}
		}
	}
}
