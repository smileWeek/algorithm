package com.study.doItCodingTest.arrayAndList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Do it! 코딩테스트
 * https://www.acmicpc.net/problem/11720
 */
public class Question1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int answer = 0;
        for(char c : input.toCharArray()){
            answer += c - '0';
        }
        System.out.println(answer);
    }
}
