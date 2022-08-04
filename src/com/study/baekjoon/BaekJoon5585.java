package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/5585
 */
public class BaekJoon5585 {
    static int[] coins = {500, 100, 50, 10, 5, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = 1000 - Integer.parseInt(br.readLine());
        int cnt = 0;
        for(int coin : coins){
            if(money % coin >= 0){
                cnt += money/coin;
                money %= coin;
            }
        }
        System.out.println(cnt);
    }
}