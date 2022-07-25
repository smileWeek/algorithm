package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/16953
 */
public class BaekJoon16953 {
    static long answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long s = Integer.parseInt(st.nextToken());
        long e = Integer.parseInt(st.nextToken());
        solution(s, e, 1);
        System.out.println((answer > 0) ? answer : -1);
    }

    private static void solution(long s, long e, long cnt) {
        if(s > e) return;
        else if(s == e) {
            answer = cnt;
            return;
        }else{
            solution(s*2, e, cnt+1);
            solution(s*10+1, e, cnt+1);
        }
    }
}