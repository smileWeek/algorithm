package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/1874
 */
public class BaekJoon1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int s = 0;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            int input = Integer.parseInt(br.readLine());
            while(s < input){
                s++;
                stack.push(s);
                sb.append("+ \n");
            }
            if(stack.peek() == input){
                stack.pop();
                sb.append("- \n");
            }else{
                sb.delete(0, sb.length());
                sb.append("NO");
                break;
            }
        }
        System.out.println(sb);
    }
}