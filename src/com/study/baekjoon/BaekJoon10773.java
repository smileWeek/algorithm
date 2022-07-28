package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/10773
 */
public class BaekJoon10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp == 0){
                if(!stack.isEmpty()) stack.pop();
            }else{
                stack.push(tmp);
            }
        }
        int answer = 0;
        while(!stack.isEmpty()){
            answer += stack.pop();
        }
        System.out.println(answer);
    }
}