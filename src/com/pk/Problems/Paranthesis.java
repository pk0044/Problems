package com.pk.Problems;

import java.util.Stack;

class Paranthesis {
    public boolean checkValidString(String s) {
    	Integer one = 1;
        Stack<String> pnts = new Stack<String>();
        String ch = "";
        int index = 0;
        int count = 0;
        while(index < s.length()){
            if(s.charAt(index) == '('){
                pnts.push(String.valueOf(s.charAt(index)));
            }else if(s.charAt(index) == '*'){
            	if(!pnts.isEmpty()) {
                	if("(".equals(pnts.peek())) {
                		pnts.push("1");
                	}else {
                		pnts.push(String.valueOf(Integer.valueOf(pnts.pop()) + one));
                	}
            	}else {
            		pnts.push("1");
            	}
            }else if(s.charAt(index) == ')'){
                if(!pnts.isEmpty()){
                    ch = pnts.pop();
                    if(!ch.equals("(")) {
                    	if(!pnts.isEmpty()) {
                    		pnts.pop();
                    		pnts.push(ch);
                    	}else {
                    		ch = String.valueOf(Integer.valueOf(ch) - one);
                    		if(!"0".equals(ch)) {
                    			pnts.push(ch);
                    		}
                    	}
                    }
                }else {
                	return false;
                }
            }
            index++;
        }
        
        boolean res = true;
        count = 0;
        String startCount = "0";
        Integer remain = 0;
        while(!pnts.isEmpty()) {
        	ch = pnts.pop();
        	if(!"(".equals(ch)) {
        		remain = remain - Integer.valueOf(count);
        		if(remain < 0) {
        			res = false;
        			break;
        		}
        		count = 0;
        	}else{
        		if(remain == Integer.valueOf(0)) {
        			return false;
        		}
        		count++;
        	}
        }
        
        if(count > remain) {
        	res = false;
        }
        
        return res;
    }
}
