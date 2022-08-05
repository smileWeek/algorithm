package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1946
 */
public class BaekJoon1946 {
    static class Recruit implements Comparable<Recruit>{
        int eScore;
        int iScore;

        public Recruit(int eScore, int iScore) {
            this.eScore = eScore;
            this.iScore = iScore;
        }

        @Override
        public int compareTo(Recruit o) {
            if(this.eScore == o.eScore) return this.iScore - o.iScore;
            else return this.eScore - o.eScore;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            ArrayList<Recruit> list = new ArrayList<>();
            for(int j = 0; j < n; j++){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int eScore = Integer.parseInt(st.nextToken());
                int iScore = Integer.parseInt(st.nextToken());
                list.add(new Recruit(eScore, iScore));
            }
            System.out.println(solution(list));
        }
    }

    private static int solution(ArrayList<Recruit> list) {
        int answer = 1;
        Collections.sort(list);
        int iScore = list.get(0).iScore;
        for(int i = 1; i < list.size(); i++){
            if(iScore > list.get(i).iScore){
                answer++;
                iScore = list.get(i).iScore;
            }
        }
        return answer;
    }
}