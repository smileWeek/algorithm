package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1931
 */
public class BaekJoon1931 {
    static int answer = 1;
    static class Meeting implements Comparable<Meeting>{
        int sTime;
        int eTime;

        public Meeting(int sTime, int eTime) {
            this.sTime = sTime;
            this.eTime = eTime;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.eTime == o.eTime) return this.sTime - o.sTime;
            else return this.eTime - o.eTime;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Meeting> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int sTime = Integer.parseInt(st.nextToken());
            int eTime = Integer.parseInt(st.nextToken());
            list.add(new Meeting(sTime, eTime));
        }
        Collections.sort(list);
        int eTime = list.get(0).eTime;
        for(int i = 1; i < list.size(); i++){
            if(eTime <= list.get(i).sTime){
                answer++;
                eTime = list.get(i).eTime;
            }
        }
        System.out.println(answer);
    }
}