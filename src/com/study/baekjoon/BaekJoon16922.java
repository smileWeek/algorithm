package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/16922
 */
public class BaekJoon16922 {
    static int[] arr = {1, 5, 10, 50};
    static int N, cnt;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[50 * 20 +1];
        dfs(0, 0, 0);
        System.out.println(cnt);
    }

    private static void dfs(int L, int idx, int sum) {
        if(L == N){
            if(!visit[sum]){
                visit[sum] = true;
                cnt++;
            }
            return;
        }else{
            for(int i = idx; i < 4; i++){
                dfs(L+1, i, sum+arr[i]);
            }
        }
    }
}