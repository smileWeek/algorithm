package com.study.inflearn.dfsAndbfsQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 4. 중복순열 구하기
 * 1부터 N까지 번호가 적힌 구슬이 있습니다. 이 중 중복을 허락하여 M번을 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
 *
 * 입력설명
 * 첫 번째 줄 자연수 N(3<=N<=10)과 M(2<=M<=N)이 주어집니다.
 *
 * 출력설명
 * 첫 번째 줄에 결과를 출력합니다.
 * 출력순서는 사전순으로 오름차순으로 출력합니다.
 *
 * 입력예제 1
 * 3 2
 *
 * 출력예제 1
 * 1 1
 * 1 2
 * 1 3
 * 2 1
 * 2 2
 * 2 3
 * 3 1
 * 3 2
 * 3 3
 *
 * 2022.07.14 해결
 */
public class Question4 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        dfs(0, n, m);
    }

    private static void dfs(int L, int n, int m) {
        if(L == m){
            for(int x : arr){
                System.out.print(x + " ");
            }
            System.out.println();
        }
        else{
            for(int i = 1; i <= n; i++){
                arr[L] = i;
                dfs(L+1, n, m);
            }
        }
    }
}
