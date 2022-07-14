package com.study.inflearn.dfsAndbfsQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 7. 조합의 경우수(메모이제이션)
 * 설명
 * 다음 공식을 사용하여 재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.
 *
 * 입력
 * 첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.
 *
 * 출력
 * 첫째 줄에 조합수를 출력합니다.
 *
 * 예시 입력 1
 * 5 3
 *
 * 예시 출력 1
 * 10
 *
 * 예시 입력 2
 * 33 19
 *
 * 예시 출력 2
 * 818809200
 *
 * 2022.07.14 해결
 */
public class Question7 {
    static int[][] dy = new int[10001][10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        System.out.println(dfs(n, r));
    }

    private static int dfs(int n, int r) {
        if(dy[n][r] != 0) return dy[n][r];
        if(n == r || r == 0) return 1;
        else{
            return dy[n][r] = dfs(n-1, r-1) + dfs(n-1, r);
        }
    }
}