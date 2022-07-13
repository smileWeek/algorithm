package com.study.inflearn.recursiveAndtreeAndgraphQuiz;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/***
 * 6. 부분집합 구하기(DFS)
 *
 * 설명
 * 자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요.
 *
 * 입력설명
 * 첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
 *
 * 출력설명
 * 첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래와 출력예제와 같은 순서로 출력한다.
 * 단 공집합은 출력하지 않습니다.
 *
 * 입력예제 1
 * 3
 *
 * 출력예제 1
 * 1 2 3
 * 1 2
 * 1 3
 * 1
 * 2 3
 * 2
 * 3
 *
 * 2022.07.12 해결
 */
public class Question6 {
    static boolean[] chk;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        chk = new boolean[n+1];
        dfs(1);
    }
    private static void dfs(int L) {
        if(L == n+1) {
            for(int i = 0; i < chk.length; i++) {
                if(chk[i]) System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        else {
            chk[L] = true;
            dfs(L+1);
            chk[L] = false;
            dfs(L+1);
        }
    }
}