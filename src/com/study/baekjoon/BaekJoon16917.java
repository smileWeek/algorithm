package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/16917
 */
public class BaekJoon16917 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int price = 0;
        if((a + b) <= (c * 2)){
            price += (a * x) + (b * y);
        }else{
            if(x > y){
                price += y * (c * 2);
                price += Math.min((x - y) * a, (x - y) * (c * 2));
            }else{
                price += x * (c * 2);
                price += Math.min((y - x) * b, (y - x) * (c * 2));
            }
        }
        System.out.println(price);
    }
}