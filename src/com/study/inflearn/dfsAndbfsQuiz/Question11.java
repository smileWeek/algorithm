package com.study.inflearn.dfsAndbfsQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/***
 * 11. 미로의 최단거리 통로(BFS)
 * 설명
 * 7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요.
 * 경로의 길이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미한다.
 * 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 도로이다.
 * 격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
 * 위와 같은 경로가 최단 경로의 길이는 12이다.
 *
 * 입력
 * 첫 번째 줄부터 7*7 격자의 정보가 주어집니다.
 *
 * 출력
 * 첫 번째 줄에 최단으로 움직인 칸의 수를 출력한다. 도착할 수 없으면 -1를 출력한다.
 *
 * 예시 입력 1
 * 0 0 0 0 0 0 0
 * 0 1 1 1 1 1 0
 * 0 0 0 1 0 0 0
 * 1 1 0 1 0 1 1
 * 1 1 0 1 0 0 0
 * 1 0 0 0 1 0 0
 * 1 0 1 0 0 0 0
 *
 * 예시 출력 1
 * 12
 *
 * 2022.07.16 해결
 */
public class Question11 {
    static class Pos{
        int x;
        int y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
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
        bfs(board);
        if (board[6][6] == 0) {System.out.println(-1);} else {System.out.println(board[6][6]);}
    }

    private static void bfs(int[][] board){
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(0,0));
        while(!queue.isEmpty()){
            Pos curr = queue.remove();
            for(int j = 0; j < dir.length; j ++) {
                int nx = curr.x + dir[j][0];
                int ny = curr.y + dir[j][1];
                if (nx >= 0 && nx <= board.length - 1 && ny >= 0 && ny <= board.length - 1 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    queue.offer(new Pos(nx, ny));
                    board[nx][ny] = board[curr.x][curr.y]+1;
                }
            }
        }
    }
}