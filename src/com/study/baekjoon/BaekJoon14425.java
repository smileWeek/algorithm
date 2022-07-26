package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14425
 */
public class BaekJoon14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        int answer = 0;
        for(int i = 0; i < n; i++){
            set.add(br.readLine());
        }
        for(int i = 0; i < m; i++){
            String input = br.readLine();
            if(set.contains(input)) answer++;
        }
        System.out.println(answer);
    }
}