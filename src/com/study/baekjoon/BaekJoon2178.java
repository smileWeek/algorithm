package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2178
 */
public class BaekJoon2178 {
    static int eRow;
    static int eCol;
    static int[][] Board = new int[101][101];
    static boolean[][] Visited = new boolean[101][101];
    static int[][] D = {{-1,0}, {1,0}, {0,1}, {0,-1}};
    static class Point{
        int row;
        int col;
        int dist;
        public Point(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        eRow = Integer.parseInt(st.nextToken());
        eCol = Integer.parseInt(st.nextToken());
        for(int i = 0; i < eRow; i++){
            String[] strArr = br.readLine().split("");
            for(int j = 0; j < eCol; j++){
                Board[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        System.out.println(bfs(eRow , eCol));
    }

    private static int bfs(int eRow, int eCol) {
        Queue<Point> queue = new LinkedList<>();
        Visited[0][0] = true;
        queue.add(new Point(0, 0, 1));

        while(!queue.isEmpty()){
            Point curr = queue.remove();
            if(eRow -1 == curr.row && eCol -1 == curr.col){
                return curr.dist;
            }
            for(int i = 0; i < 4; i++){
                int nx = curr.row + D[i][0], ny = curr.col + D[i][1];
                if(nx < 0 || nx > eRow -1 || ny < 0 || ny > eCol -1) continue;
                if(Visited[nx][ny])continue;
                if(Board[nx][ny] == 0) continue;
                Visited[nx][ny] = true;
                queue.add(new Point(nx, ny, curr.dist + 1));
            }
        }
        return -1;
    }
}
