package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10815
 */
public class BaekJoon10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(set, arr));
    }

    private static String solution(Set<Integer> set, int[] arr) {
        StringBuilder sb = new StringBuilder();
        for(int num : arr){
            sb = (set.contains(num)) ? sb.append("1 ") : sb.append("0 ");
        }
        return sb.toString();
    }
}