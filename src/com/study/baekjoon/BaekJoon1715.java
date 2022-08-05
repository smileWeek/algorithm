package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * https://www.acmicpc.net/problem/1715
 */
public class BaekJoon1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            queue.offer(Integer.parseInt(br.readLine()));
        }
        int answer = 0;
        while(queue.size() > 1){
            int sum = queue.poll() + queue.poll();
            queue.offer(sum);
            answer += sum;
        }
        System.out.println(answer);
    }
}