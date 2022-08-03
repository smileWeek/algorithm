package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/7576
 */
public class BaekJoon7576 {
    static int M;
    static int N;
    static int[][] Board;
    static boolean[][] Visited;
    static int[][] Dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static int[][] Dir1 = {{-2,0},{2,0},{0,-2},{0,2}};
    static Queue<Point> queue = new LinkedList<>();
    static class Point{
        int row;
        int col;
        public Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Board = new int[N][M];
        Visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            String[] strArr = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                int x = Integer.parseInt(strArr[j]);
                if(x == 1) queue.add(new Point(i, j));
                Board[i][j] = x;
            }
        }
        while(!queue.isEmpty()){
            Point curr = queue.remove();
            Visited[curr.row][curr.col] = true;
            for(int i = 0 ; i < 4; i++){
                int nx = curr.row + Dir[i][0], ny = curr.col + Dir[i][1];
                if(nx < 0 || nx > N -1 || ny < 0 || ny > M-1) continue;
                if(!Visited[nx][ny] && Board[nx][ny] == 0){
                    Visited[nx][ny] = true;
                    Board[nx][ny] = Board[curr.row][curr.col] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        int day = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(Board[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                day = Math.max(day, Board[i][j]);
            }
        }
        System.out.println(day -1);
    }
}