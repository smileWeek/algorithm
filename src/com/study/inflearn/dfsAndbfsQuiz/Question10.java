package com.study.inflearn.dfsAndbfsQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 10. 미로탐색(DFS)
 * 설명
 * 7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.
 * 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.
 * 격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
 * 위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다.
 *
 * 입력
 * 7*7 격자판의 정보가 주어집니다.
 *
 * 출력
 * 첫 번째 줄에 경로의 가지수를 출력한다.
 *
 * 예시 입력 1
 * 0 0 0 0 0 0 0
 * 0 1 1 1 1 1 0
 * 0 0 0 1 0 0 0
 * 1 1 0 1 0 1 1
 * 1 1 0 0 0 0 1
 * 1 1 0 1 1 0 0
 * 1 0 0 0 0 0 0
 *
 * 예시 출력 1
 * 8
 *
 * 2022.07.16 해결
 */
public class Question10 {
    static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[7][7];
        StringTokenizer st;
        for(int i = 0; i < board.length; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        board[0][0] = 1;
        dfs(0,0, board);
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int[][] board) {
        if(x == 6 && y == 6) answer++;
        else{
            for(int i = 0; i < dir.length; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if(nx >= 0 && nx <= 6 && ny >= 0 && ny <= 6 && board[nx][ny] == 0) {
                    board[nx][ny]= 1;
                    dfs(nx, ny, board);
                    board[nx][ny]= 0;
                }
            }
        }
    }
}