package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/11729
 */
public class BaekJoon11729{
    static int count = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        hanoi(n, 1, 2, 3, sb);
        System.out.println(count);
        System.out.println(sb);
    }

    private static void hanoi(int n, int start, int sub, int to, StringBuilder sb) {
        count++;
        if(n == 1){
            sb.append(start + " " + to + "\n");
            return;
        }
        hanoi(n-1, start, to, sub, sb);
        sb.append(start + " " + to + "\n");
        hanoi(n-1, sub, start, to, sb);
    }
}