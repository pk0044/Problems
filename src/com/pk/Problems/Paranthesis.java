package com.pk.Problems;

import java.util.Stack;

class Paranthesis {
    public boolean checkValidString(String s) {

		boolean res = true;
		
		Stack<Integer> pnts = new Stack<Integer>();
		
		int size = s.length();
		
		int index = 0;
		int temp = 0;
		
		while(index < size) {
			if(s.charAt(index) == '(') {
				pnts.push(-1);
			}else if(s.charAt(index) == ')') {
				if(!pnts.empty()) {
					temp = pnts.pop();
					if(temp != -1 && !pnts.empty()) {
						pnts.pop();
						if(!pnts.empty() && pnts.peek() == -1) {
							pnts.push(temp);
						}else if(!pnts.isEmpty() && pnts.peek() != -1) {
							pnts.push(pnts.pop() + temp);
						}else {
							pnts.push(temp);
						}
					}else if(temp != -1 && pnts.isEmpty()) {
						pnts.push(temp - 1);
					}
				}else {
					return false;
				}
			}else if(s.charAt(index) == '*') {
				if(!pnts.isEmpty() && pnts.peek() == -1) {
					pnts.push(1);
				}else if(!pnts.isEmpty() && pnts.peek() != -1) {
					pnts.push(pnts.pop() + 1);
				}else {
					pnts.push(1);
				}
			}
			index++;
		}
		
		int top = 0;
		int remain = 0;
		while(!pnts.isEmpty()) {
			top = pnts.pop();
			if(top == -1) {
				if(remain <= 0) {
					res = false;
					break;
				}else {
					remain = remain - 1;
				}
			}else if(top != -1) {
				remain = remain + top;
			}
		}
		return res;

    }
}
