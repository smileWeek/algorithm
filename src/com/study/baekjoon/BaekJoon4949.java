package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/4949
 */
public class BaekJoon4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String str = br.readLine();
            if(".".equals(str)){
                break;
            }
            System.out.println(isParenthesis(str));
        }
    }

    private static String isParenthesis(String str) {
        String answer = "no";
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(c == '(' || c == '[') stack.push(c);
            else if (c == ')' || c == ']'){
                if(stack.isEmpty()) stack.push(c);
                else{
                    if(stack.peek() == '(' && c == ')') stack.pop();
                    else if(stack.peek() == '[' && c == ']') stack.pop();
                    else stack.push(c);
                }
            }
        }
        if(stack.isEmpty()) answer = "yes";
        return answer;
    }
}