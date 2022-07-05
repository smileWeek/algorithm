package com.study.inflearn.twoPtQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/***
 *4. 연속 부분수열
 * 설명
 * N개의 수로 이루어진 수열이 주어집니다.
 * 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
 * 만약 N=8, M=6이고 수열이 다음과 같다면
 * 1 2 1 3 1 1 1 2
 * 합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.
 *
 * 입력
 * 첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
 * 수열의 원소값은 1,000을 넘지 않는 자연수이다.
 *
 * 출력
 * 첫째 줄에 경우의 수를 출력한다.
 *
 * 예시 입력 1
 * 8 6
 * 1 2 1 3 1 1 1 2
 *
 * 예시 출력 1
 * 3
 *
 * 2022.07.05 해결
 */
public class Question4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(m, arr));
    }

    private static int solution(int m, int[] arr) {
        int answer = 0;
        int lt = 0;
        int sum = 0;
        for(int rt = 0; rt < arr.length; rt++){
            sum += arr[rt];
            if(sum == m) answer++;
            while(sum > m){
                sum -= arr[lt++];
                if(sum == m) answer++;
            }
        }
        return answer;
    }
}
