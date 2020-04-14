package com.pk.Problems;

class StringShift {
    public String stringShift(String s, int[][] shift) {
        int size = shift.length;
        
        int sum = 0;
        
        for(int i=0; i<size; i++){
            if(shift[i][0] == 0){
                sum = sum - shift[i][1];
            }else{
                sum = sum + shift[i][1];
            }
        }
        
        String res = "";
        
        if(sum < 0){
            sum = sum * -1;
            sum = sum % s.length();
            res = res + s.substring(sum, s.length()) + s.substring(0, sum);
        }else if(sum > 0){
        	sum = sum % s.length();
            res = s.substring(s.length()-sum, s.length()) + s.substring(0, s.length()-sum);
        }else{
            res = s;
        }
        
        return res;
    }
}