package com.pk.Problems;


import java.util.*; 
import java.io.*;

/**
 * Given a String of mathematical expression change the expression by removing only parenthesis and change the sign accordingly. No need to solve the expression just solve parenthesis part
 * 
 * Note : output string should not contain any space characters
 * Example :
 * 
 * input : "a - (b - (x - y - z))"
 * output : "a-b+x-y-z"
 * 
 * @author pk0044
 *
 */

class Bproblems {

  public  String BRule(String str) {
    Stack<Character> stack = new Stack<Character>();
    Stack<Integer> mulStack = new Stack<Integer>();
    String res = "";
    int i = 0;
    int mul = 1;
    while(i < str.length()){
      if(str.charAt(i) == '+'){
        if(!mulStack.isEmpty() && mulStack.peek() == -1){
          res = res.concat("-");
        }else{
          res = res.concat("+");
        }
      }else if(str.charAt(i) == '-'){
        if(!mulStack.isEmpty() && mulStack.peek() == -1){
          res = res.concat("+");
        }else{
          res = res.concat("-");
        }
      }else if(str.charAt(i) == '('){
        if(res.charAt(res.length() - 1) == '-'){
          mulStack.push(-1);
        }else{
          mulStack.push(1);
        }
        stack.push('(');
      }else if(str.charAt(i) == ')'){
        stack.pop();
        mulStack.pop();
      }else if(str.charAt(i) != ' '){
        res = res.concat(String.valueOf(str.charAt(i)));
      }
      i++;
    }
    return res;
  }

}
