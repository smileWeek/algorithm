package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/11659
 */
public class BaekJoon2606 {
    static int Node;
    static int Line;
    static int Count = 0;
    static int[][] Board;
    static boolean[] Visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node = Integer.parseInt(br.readLine());
        Line = Integer.parseInt(br.readLine());
        Board = new int[Node + 1][Node + 1];
        Visited = new boolean[Node +1];
        for(int i = 0; i < Line; i++){
            String str = br.readLine();
            int v = Integer.parseInt(str.split(" ")[0]);
            int n = Integer.parseInt(str.split(" ")[1]);
            Board[v][n] = Board[n][v] = 1;
        }
        dfs(1);
        System.out.println(Count - 1);
    }

    private static void dfs(int start) {
        Visited[start] = true;
        Count ++;
        for(int i = 0; i <= Node; i++){
            if(Board[start][i] == 1 && !Visited[i]) dfs(i);
        }
    }
}
