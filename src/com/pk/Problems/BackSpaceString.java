package com.pk.Problems;

class BackSpaceString {
    public boolean backspaceCompare(String S, String T) {
        int l1 = S.length()-1;
        int l2 = T.length()-1;
        int c1 = 0;
        int c2 = 0;
        boolean res = true;
        // use another counter to store the '#' characters
        while(l1 >= 0 && l2 >= 0){
            while(l1>=0){
                if(S.charAt(l1) == '#'){
                    l1--;
                    c1++;
                }else if(c1 > 0){
                    l1--;
                    c1--;
                }else{
                    break;
                }
            }
            
            while(l2 >= 0){
                if(T.charAt(l2) == '#'){
                    l2--;
                    c2++;
                }else if(c2 > 0){
                    l2--;
                    c2--;
                }else{
                    break;
                }
            }
            
            if((l1 >= 0 && l2 >= 0) && S.charAt(l1) != T.charAt(l2)){
                res = false;
                break;
            }
            
            l1--;
            l2--;
            c1 = 0;
            c2 = 0;
        }
        
         
             c1 = 0;
             c2 = 0;
             while(l1 >= 0){
                 if(S.charAt(l1) == '#'){
                     c1++;
                     l1--;
                 }else if(c1 > 0){
                     l1--;
                     c1--;
                 }else{
                     res = false;
                     break;
                 }
             }
             
            while(l2 >= 0){
                 if(T.charAt(l2) == '#'){
                     c2++;
                     l2--;
                 }else if(c2 > 0){
                     l2--;
                     c2--;
                 }else{
                     res = false;
                     break;
                 }
             }
        
        
        if(l1 != l2){
            res = false;
        }
        
        
        return res;
    }
}
