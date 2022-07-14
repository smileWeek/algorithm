package com.study.inflearn.dfsAndbfsQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/***
 * 5. 동전교환
 * 설명
 *
 * 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
 *
 * 각 단위의 동전은 무한정 쓸 수 있다.
 *
 *
 * 입력
 * 첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고,
 *
 * 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.각 동전의 종류는 100원을 넘지 않는다.
 *
 *
 * 출력
 * 첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
 *
 *
 * 예시 입력 1
 *
 * 3
 * 1 2 5
 * 15
 * 예시 출력 1
 * 3
 * 힌트
 * 5. 동전교환
 * 설명
 * 다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?
 * 각 단위의 동전은 무한정 쓸 수 있다.
 *
 * 입력
 * 첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고,
 * 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.각 동전의 종류는 100원을 넘지 않는다.
 *
 * 출력
 * 첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.
 *
 * 예시 입력 1
 * 3
 * 1 2 5
 * 15
 *
 * 예시 출력 1
 * 3
 *
 * 힌트
 * 출력 설명 : 5 5 5 동전 3개로 거슬러 줄 수 있다.
 *
 * 2022.07.14 해결
 */
public class Question5 {
    static int m;
    static int[] chk = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        System.out.println(bfs(arr));
    }

    private static int bfs(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        for(int x : arr){
            queue.offer(x);
            chk[x] = 1;
        }
        int answer = Integer.MAX_VALUE;
        int cnt = 1;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i++){
                int curr = queue.poll();
                if(curr == m) answer = Math.min(answer, cnt);
                for(int j = 0; j < arr.length; j++){
                    int sum = curr + arr[j];
                    if(sum <= m && chk[sum] == 0) {
                        chk[sum] = 1;
                        queue.offer(sum);
                    }
                }
            }
            cnt++;
        }
        return answer;
    }
}