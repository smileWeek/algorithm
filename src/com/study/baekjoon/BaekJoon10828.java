package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/10828
 */
public class BaekJoon10828 {
    static List<Integer> stack = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String[] command  = br.readLine().split(" ");
            executeCommand(command);
        }
    }

    private static void executeCommand(String[] command) {
        switch (command[0]){
            case ("push") :
                stack.add(Integer.parseInt(command[1]));
                break;
            case ("pop") :
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.get(stack.size() - 1));
                    stack.remove(stack.size() - 1);
                }
                break;
            case ("top") :
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.get(stack.size() - 1));
                }
                break;
            case ("size") :
                System.out.println(stack.size());
                break;
            case ("empty") :
                System.out.println((stack.isEmpty()) ? 1 : 0);
                break;
            default:
                break;
        }
    }
}