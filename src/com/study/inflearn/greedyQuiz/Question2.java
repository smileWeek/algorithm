package com.study.inflearn.greedyQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/***
 * 2. 회의실 배정
 * 설명
 * 한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들려고 한다.
 * 각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.
 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 *
 * 입력
 * 첫째 줄에 회의의 수 n(1<=n<=100,000)이 주어진다. 둘째 줄부터 n+1 줄까지 각 회의의 정보가 주어지는데
 * 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 회의시간은 0시부터 시작한다.
 * 회의의 시작시간과 끝나는 시간의 조건은 (시작시간 <= 끝나는 시간)입니다.
 *
 * 출력
 * 첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.
 *
 * 예시 입력 1
 * 5
 * 1 4
 * 2 3
 * 3 5
 * 4 6
 * 5 7
 *
 * 예시 출력 1
 * 3
 *
 * 예시 입력 2
 * 3
 * 3 3
 * 1 3
 * 2 3
 *
 * 예시 출력 2
 * 2
 *
 * 2022.07.19 해결
 */
public class Question2 {
    static class Time implements Comparable<Time>{
        int sTime;
        int eTime;

        public Time(int sTime, int eTime) {
            this.sTime = sTime;
            this.eTime = eTime;
        }

        @Override
        public int compareTo(Time o) {
            if(this.eTime == o.eTime) return this.sTime - this.eTime;
            else return this.eTime - o.eTime;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Time> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int sTime = Integer.parseInt(st.nextToken());
            int eTime = Integer.parseInt(st.nextToken());
            list.add(new Time(sTime, eTime));
        }
        System.out.println(solution(list));
    }

    private static int solution(ArrayList<Time> list) {
        int answer = 1;
        Collections.sort(list);
        int eTime = list.get(0).eTime;
        for(int i = 1; i < list.size(); i++){
            if(eTime <= list.get(i).sTime){
                answer++;
                eTime = list.get(i).eTime;
            }
        }
        return answer;
    }
}
