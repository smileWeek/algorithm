package com.study.inflearn.recursiveAndtreeAndgraphQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 2. 재귀함수를 이용한 이진수 출력
 *
 * 설명
 * 10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하세요.
 * 단 재귀함수를 이용해서 출력해야 합니다.
 *
 * 입력
 * 첫 번째 줄에 10진수 N(1<=N<=1,000)이 주어집니다.
 *
 * 출력
 * 첫 번째 줄에 이진수를 출력하세요.
 *
 * 예시 입력 1
 * 11
 *
 * 예시 출력 1
 * 1011
 *
 * 2022.07.11 해결
 */
public class Question2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        solution(n);
    }

    private static void solution(int n) {
        if(n == 0) return;
        else{
            solution(n / 2);
            System.out.print(n % 2);
        }
    }
}
