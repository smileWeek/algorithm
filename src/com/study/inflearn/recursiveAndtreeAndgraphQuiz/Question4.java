package com.study.inflearn.recursiveAndtreeAndgraphQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/***
 * 4. 피보나치 수열
 * 1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개 수를 합하여 다음 숫가 되는 수열이다.
 * 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
 *
 * 입력
 * 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
 *
 * 출력
 * 첫 줄에 피보나치 수열을 출력합니다.
 *
 * 예시 입력 1
 * 10
 *
 * 예시 출력 1
 * 1 1 2 3 5 8 13 21 34 55
 *
 * 2022.07.11 해결
 */
public class Question4 {
    static int[] fibo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fibo = new int[n+1];
        solution(n);
        Arrays.stream(fibo).filter(i -> (i != 0)).forEach(i -> System.out.print(i + " "));
    }

    private static int solution(int n) {
        if(n == 2) return fibo[n] = 1;
        else if(n == 1) return fibo[n] = 1;
        else return fibo[n] = solution(n -2) + solution(n -1);
    }
}
