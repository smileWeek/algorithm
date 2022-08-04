package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/10162
 */
public class BaekJoon10162 {
    static int[] oven = {300, 60, 10};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[3];
        if(String.valueOf(n).endsWith("0")){
            for(int i = 0; i < 3; i++){
                answer[i] = n / oven[i];
                n %= oven[i];
            }
            Arrays.stream(answer).forEach(i -> System.out.print(i + " "));
        }else{
            System.out.println(-1);
        }
    }
}