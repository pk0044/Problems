package com.pk.Problems;

public class Test {
	public void test() {
		String name = "purushottam";
		
		System.out.println(name.substring(1));
//		char s[] = {'a','b','c'};
//		System.out.println(s);
//		System.out.println(s[0]);
//		System.out.println(s+1);
	}
	
	
	public void reversUtil(int start, int end) {
		revers
	}
	
	public void revereString(char[] s) {
		int lenght = s.length;
		reversString()
	}
	
	
    public  String reverseString(String str)
    {
        if (str.isEmpty()) 
            return str;
        //Calling Function Recursively
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}
