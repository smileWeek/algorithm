package com.study.inflearn.arrQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 9. 격자판 최대합
 * 설명
 * 5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
 * N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
 *
 * 입력
 * 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
 * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
 *
 * 출력
 * 최대합을 출력합니다.
 *
 * 예시 입력 1
 *
 * 5
 * 10 13 10 12 15
 * 12 39 30 23 11
 * 11 25 50 53 15
 * 19 27 29 37 27
 * 19 13 30 13 19
 *
 * 예시 출력 1
 * 155
 *
 * 2022.07.04 해결
 */
public class Question9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(board));
    }

    private static int solution(int[][] board) {
        int answer = 0;
        int sum1,sum2;
        for(int i = 0; i < board.length; i++){
            sum1=sum2=0;
            for(int j = 0; j < board[i].length; j++){
                sum1 += board[i][j];
                sum2 += board[j][i];
            }
            answer = Math.max(answer, Math.max(sum1, sum2));
        }
        sum1=sum2=0;
        for(int i = 0; i < board.length; i++){
            sum1 += board[i][i];
            sum2 += board[i][board.length-1-i];
        }
        answer = Math.max(answer, Math.max(sum1, sum2));
        return answer;
    }
}
