package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2667
 */
public class BaekJoon2667 {
    static int N;
    static int[][] Dir = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    static int[][] ApartMents;
    static boolean[][] Visited;
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
        N = Integer.parseInt(br.readLine());
        ApartMents = new int[N][N];
        Visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            String[] strArr = br.readLine().split("");
            for(int j = 0; j < N; j++){
                ApartMents[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        ArrayList<Integer> rList = bfs();
        System.out.println(rList.size());
        rList.stream().forEach(System.out::println);
    }

    private static ArrayList<Integer> bfs() {
        ArrayList<Integer> intList = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int cnt;
                if(ApartMents[i][j] == 1 && !Visited[i][j]){
                    cnt = getCount(i, j);
                    if(cnt > 0) intList.add(cnt);
                }
            }
        }
        Collections.sort(intList);
        return intList;
    }

    private static int getCount(int row, int col) {
        int count = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(row, col));
        Visited[row][col] = true;
        while(!queue.isEmpty()){
            Point curr = queue.remove();
            for(int i = 0; i < 4; i++){
                int nx = curr.row +Dir[i][0], ny = curr.col +Dir[i][1];
                if(nx < 0 || nx > N-1 || ny < 0 || ny > N-1 ) continue;
                if(Visited[nx][ny]) continue;
                if(ApartMents[nx][ny] == 0) continue;
                Visited[nx][ny] = true;
                queue.add(new Point(nx, ny));
                count++;
            }
        }
        return count;
    }
}
