package com.study.inflearn.recursiveAndtreeAndgraphQuiz;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 11. 경로 탐색(인접행렬)
 *
 * 설명
 * 방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프로그램을 작성하세요.
 * 아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지 수는
 * 1 2 3 4 5
 * 1 2 5
 * 1 3 4 2 5
 * 1 3 4 5
 * 1 4 2 5
 * 1 4 5
 *
 * 총 6가지 입니다.
 *
 * 입력설명
 * 첫째 줄에 정점의 수 N(1<=N<=20)와 간선의 수 M이 주어진다. 그 다음부터 M줄에 걸쳐 연결정보가 주어진다.
 *
 * 출력설명
 * 총 가지수를 출력한다.
 *
 * 입력예제 1
 * 5 9
 * 1 2
 * 1 3
 * 1 4
 * 2 1
 * 2 3
 * 2 5
 * 3 4
 * 4 2
 * 4 5
 *
 * 출력예제 1
 * 6
 *
 * 2022.07.12 해결
 */
public class Question11 {
    static int n, m, answer = 0;
    static int[][] board;
    static int[] chk;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n+1][n+1];
        chk = new int[n+1];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = 1;
        }
        chk[1] = 1;
        dfs(1);
        System.out.println(answer);
    }
    private static void dfs(int v) {
        if(v == n) answer++;
        else {
            for(int i = 1; i <= n; i++) {
                if(board[v][i] == 1 && chk[i] == 0) {
                    chk[i] = 1;
                    dfs(i);
                    chk[i] = 0;
                }
            }
        }
    }
}
