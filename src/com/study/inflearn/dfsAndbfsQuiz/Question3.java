package com.study.inflearn.dfsAndbfsQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/***
 * 3. 최대점수 구하기(DFS)
 * 설명
 * 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
 * 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
 * 제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
 * (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)
 *
 * 입력
 * 첫 번째 줄에 문제의 개수N(1<=N<=20)과 제한 시간 M(10<=M<=300)이 주어집니다.
 * 두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.
 *
 * 출력
 * 첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.
 *
 * 예시 입력 1
 * 5 20
 * 10 5
 * 25 12
 * 15 8
 * 6 3
 * 7 4
 *
 * 예시 출력 1
 * 41
 *
 * 2022.07.13 해결
 */
public class Question3 {
    static int n, m, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[] scores = new int[n];
        int[] times = new int[n];
        for(int i = 0 ; i < n; i++){
            String input = br.readLine();
            int score = Integer.parseInt(input.split(" ")[0]);
            int time = Integer.parseInt(input.split(" ")[1]);
            scores[i] = score;
            times[i] = time;
        }
        dfs(0,0, 0, scores, times);
        System.out.println(answer);
    }

    private static void dfs(int L, int T, int sum, int[] scores, int[] times) {
        if(T > m) return;
        if(L == n){
            answer = Math.max(answer, sum);
        }else{
            dfs(L+1,T+times[L], sum+scores[L], scores, times);
            dfs(L+1,T, sum, scores, times);
        }
    }
}
