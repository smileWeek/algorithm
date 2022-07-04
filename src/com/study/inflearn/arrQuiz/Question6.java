package com.study.inflearn.arrQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/***
 * 6. 뒤집은 소수
 * 설명
 * N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
 * 예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
 * 첫 자리부터의 연속된 0은 무시한다.
 *
 * 입력
 * 첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
 * 각 자연수의 크기는 100,000를 넘지 않는다.
 *
 * 출력
 * 첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
 *
 * 예시 입력 1
 * 9
 * 32 55 62 20 250 370 200 30 100
 *
 * 예시 출력 1
 * 23 2 73 2 3
 *
 * 2022.07.04 해결
 */
public class Question6 {
    static int[] chk = new int[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        setPrimeNum();
        Arrays.stream(solution(n, arr)).forEach(i -> System.out.print(i + " "));
    }

    private static int[] solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int res = 0;
            int tmp = arr[i];
            while(tmp > 0){
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }
            if(chk[res] == 0) answer.add(res);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void setPrimeNum() {
        chk[0] = 1;
        chk[1] = 1;
        for(int i = 2; i < chk.length; i++){
            if(chk[i] == 0){
                for(int j = i * 2; j < chk.length; j += i) chk[j] = 1;
            }
        }
    }
}
