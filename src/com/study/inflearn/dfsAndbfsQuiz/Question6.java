package com.study.inflearn.dfsAndbfsQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 * 6. 순열 구하기
 * 10이하의 N개의 자연수가 주어지면 이 중 M개를 뽑아 일렬로 나열하는 방법을 모두 출력합니다.
 *
 * 입력설명
 * 첫 번째 줄에 자연수 N(3<=N<=10) 과 M(2<=M<=N)이 주어집니다.
 * 두 번째 줄에 N개의 자연수가 오름차순으로 주어집니다.
 *
 * 출력설명
 * 첫 번째 줄에 결과를 출력합니다.
 * 출력순서는 사전순으로 오름차순으로 출력합니다.
 *
 * 입력예제 1
 * 3 2
 * 3 6 9
 *
 * 출력예제 1
 * 3 6
 * 3 9
 * 6 3
 * 6 9
 * 9 3
 * 9 6
 *
 * 2022.07.14 해결
 */
public class Question6 {
    static int[] num;
    static boolean[] chk;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        num = new int[m];
        chk = new boolean[n];
        dfs(0, m, n, arr);
    }

    private static void dfs(int L, int m, int n, int[] arr) {
        if(L == m){
            for(int x : num) System.out.print(x + " ");
            System.out.println();
        }else{
            for(int i = 0; i < n; i++){
                if(!chk[i]){
                    chk[i] = true;
                    num[L] = arr[i];
                    dfs(L+1, m, n, arr);
                    chk[i] = false;
                }
            }
        }
    }
}
