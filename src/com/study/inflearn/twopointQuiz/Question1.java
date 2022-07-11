package com.study.inflearn.twopointQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/***
 * 1. 두 배열 합치기
 * 설명
 * 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.
 * 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
 * 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.
 * 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
 * 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.
 *
 * 출력
 * 오름차순으로 정렬된 배열을 출력합니다.
 *
 * 예시 입력 1
 * 3
 * 1 3 5
 * 5
 * 2 3 6 7 9
 *
 * 예시 출력 1
 * 1 2 3 3 5 6 7 9
 *
 * 2022.07.05 해결
 */
public class Question1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.stream(solution(n, m, arr1, arr2)).forEach(i -> System.out.print(i + " "));
    }

    private static int[] solution(int n, int m, int[] arr1, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        int pi = 0, pj = 0;
        while(pi < n && pj < m){
            if(arr1[pi] < arr2[pj]) answer.add(arr1[pi++]);
            else answer.add(arr2[pj++]);
        }
        while(pi < n) answer.add(arr1[pi++]);
        while(pj < m) answer.add(arr2[pj++]);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
