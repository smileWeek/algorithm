package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.acmicpc.net/problem/1032
 */
public class BaekJoon1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strArr = new String[n];
        for(int i = 0; i < n; i++){
            strArr[i] = br.readLine();
        }
        System.out.println(solution(strArr));
    }

    private static String solution(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strArr[0].length(); i++){
            Set<Character> set = new HashSet<>();
            for(int j = 0; j < strArr.length; j++){
                set.add(strArr[j].charAt(i));
            }
            sb.append((set.size() == 1 ? set.stream().findFirst().get() : '?'));
        }
        return sb.toString();
    }
}