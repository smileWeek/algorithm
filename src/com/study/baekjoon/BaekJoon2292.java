package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/2292
 */
public class BaekJoon2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int honey = 1;
        int count = 1;
        while(true){
            if(A <= honey)break;
            else{
                honey = honey + (count * 6);
                count++;
            }
        }
        System.out.println(count);
    }
}