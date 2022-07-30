package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

/**
 * https://www.acmicpc.net/problem/18258
 */
public class BaekJoon18258 {
    static LinkedList<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String[] command = br.readLine().split(" ");
            executeCommand(command);
        }
        System.out.println(sb);
    }

    private static void executeCommand(String[] command) {
        switch (command[0]){
            case ("push") :
                queue.add(Integer.parseInt(command[1]));
                break;
            case ("front") :
                if(queue.isEmpty()) sb.append(-1 + "\n");
                else sb.append(queue.peekFirst() + "\n");
                break;
            case ("back") :
                if(queue.isEmpty()) sb.append(-1 + "\n");
                else sb.append(queue.peekLast() + "\n");
                break;
            case ("size") :
                sb.append(queue.size() + "\n");
                break;
            case ("pop") :
                if(queue.isEmpty())sb.append(-1 + "\n");
                else{
                    sb.append(queue.pop() + "\n");
                }
                break;
            case ("empty") :
                if(queue.isEmpty()) sb.append(1 + "\n");
                else sb.append(0 + "\n");
                break;
            default:
                break;
        }
    }
}