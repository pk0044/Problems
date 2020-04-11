package com.pk.Problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
	
	public String[] readfile() throws FileNotFoundException {
		File file = new File("input.txt");
		Scanner sc = new Scanner(file);
		
		int i = 0;
		
		String[] inputs = new String[4];
		
		while(sc.hasNext()) {
			inputs[i] = sc.nextLine();
			i++;
		}
		return inputs;
	}
	
	
}
