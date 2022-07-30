package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1966
 */
public class BaekJoon1966 {
    static class Printer{
        int seq;
        int idx;

        public Printer(int seq, int idx) {
            this.seq = seq;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());
        for(int i = 0; i < c; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            LinkedList<Printer> queue = new LinkedList<>();
            for(int j = 0; j < m; j++){
                int seq = Integer.parseInt(st.nextToken());
                queue.offer(new Printer(seq, j));
            }
            System.out.println(solution(queue, n));
        }
    }

    private static int solution(LinkedList<Printer> queue, int n) {
        int answer = 0;
        while(!queue.isEmpty()){
            Printer p = queue.poll();
            boolean isMax = true;
            for(int i = 0; i < queue.size(); i++){
                if(p.seq < queue.get(i).seq){
                    queue.offer(p);
                    for(int j = 0; j < i; j++){
                        queue.offer(queue.poll());
                    }
                    isMax = false;
                    break;
                }
            }
            if(!isMax) continue;
            answer++;
            if(p.idx == n)break;
        }
        return answer;
    }
}