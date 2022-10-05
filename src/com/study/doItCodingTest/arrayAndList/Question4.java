package com.study.doItCodingTest.arrayAndList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Do it! 코딩테스트
 * https://www.acmicpc.net/problem/11660
 */

public class Question4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] sumBoard = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                sumBoard[i][j] = sumBoard[i][j-1] + sumBoard[i-1][j] - sumBoard[i-1][j-1] + board[i][j];
            }
        }
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = sumBoard[x2][y2] -sumBoard[x1-1][y2] - sumBoard[x2][y1 - 1] + sumBoard[x1 -1][y1 - 1];
            System.out.println(result);
        }
    }
}