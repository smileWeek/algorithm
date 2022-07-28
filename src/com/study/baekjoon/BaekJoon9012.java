package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/9012
 */
public class BaekJoon9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            System.out.println(isParenthesis(br.readLine()));
        }
    }

    private static String isParenthesis(String str) {
        String answer = "NO";
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(c == '(') stack.push(c);
            else if(c == ')'){
                if(!stack.isEmpty()){
                    if(stack.peek() == '(') stack.pop();
                    else stack.push(c);
                }else{
                    stack.push(c);
                }
            }
        }
        if(stack.size() == 0) answer = "YES";
        return answer;
    }
}