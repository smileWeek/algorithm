package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1012
 */
public class BaekJoon1012 {
    static int M;
    static int N;
    static int C;
    static int[][] Board;
    static boolean[][] Visited;
    static int[][] Dir = {{-1,0},{1,0},{0,-1},{0,1}};
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
        C = Integer.parseInt(br.readLine());
        for(int test = 0; test < C; test++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            Board = new int[N][M];
            Visited= new boolean[N][M];
            for(int i = 0; i < cnt; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                Board[x][y] = 1;
            }
            int count = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(!Visited[i][j] && Board[i][j] == 1){
                        bfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void bfs(int n, int m) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(n, m));
        Visited[n][m] = true;
        while(!queue.isEmpty()){
            Point curr = queue.remove();
            for(int i = 0; i < 4; i++){
                int nx = curr.row + Dir[i][0], ny = curr.col + Dir[i][1];
                if(nx < 0 || nx > N -1 || ny < 0 || ny > M -1)continue;
                if(!Visited[nx][ny] && Board[nx][ny] == 1){
                    Visited[nx][ny] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }
}
