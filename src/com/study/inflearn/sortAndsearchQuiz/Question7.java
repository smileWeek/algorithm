package com.study.inflearn.sortAndsearchQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/***
 * 7. 좌표 정렬
 * 설명
 * N개의 평면상의 좌표(x, y)가 주어지면 모든 좌표를 오름차순으로 정렬하는 프로그램을 작성하세요.
 * 정렬기준은 먼저 x값의 의해서 정렬하고, x값이 같을 경우 y값에 의해 정렬합니다.
 *
 * 입력
 * 첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
 * 두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.
 *
 * 출력
 * N개의 좌표를 정렬하여 출력하세요.
 *
 * 예시 입력 1
 * 5
 * 2 7
 * 1 3
 * 1 2
 * 2 5
 * 3 6
 *
 * 예시 출력 1
 * 1 2
 * 1 3
 * 2 5
 * 2 7
 * 3 6
 *
 * 2022.07.09 해결
 */
public class Question7 {
    static class Pos implements Comparable<Pos>{
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pos o) {
            if(this.x == o.x) return this.y - o.y;
            else return this.x - o.x;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        ArrayList<Pos> answer = new ArrayList<>();
        StringTokenizer st;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 2; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution(arr).stream().forEach(i -> System.out.println(i.x + " " + i.y));
    }

    private static ArrayList<Pos> solution(int[][] arr) {
        ArrayList<Pos> answer = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            int x = arr[i][0];
            int y = arr[i][1];
            answer.add(new Pos(x,y));
        }
        Collections.sort(answer);
        return answer;
    }
}
