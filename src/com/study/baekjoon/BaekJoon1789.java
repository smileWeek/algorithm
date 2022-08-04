package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1789
 */
public class BaekJoon1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        long i = 0;
        long sum = 0;
        long n = 0;
        while(sum < S){
            sum += ++i;
            if(sum > S){
                break;
            }
            n++;
        }
        System.out.println(n);
    }
}