package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13305
 */
public class BaekJoon13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long[] oils = new long[(int) (n - 1)];
        long[] cities = new long[(int) (n - 1)];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < oils.length; i++){
            oils[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < cities.length; i++){
            cities[i] = Long.parseLong(st.nextToken());
        }
        long answer = 0;
        long min = cities[0];
        for(int i = 0; i < n-1; i++){
            if(min > cities[i]){
                min = cities[i];
            }else{
                cities[i] = min;
            }
            answer += min * oils[i];
        }
        System.out.println(answer);
    }
}