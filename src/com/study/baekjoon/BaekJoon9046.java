package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.acmicpc.net/problem/9046
 */
public class BaekJoon9046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strArr = new String[n];
        for(int i = 0; i < n; i++){
            strArr[i] = br.readLine();
        }
        solution(strArr).stream().forEach(System.out::println);
    }

    private static List<Character> solution(String[] strArr) {
        List<Character> answer = new ArrayList<>();
        for(String str : strArr){
            int[] arr = new int[26];
            for(char c : str.toCharArray()){
                if(c == ' ')continue;
                arr[c - 'a']++;
            }
            answer.add(getChar(arr));
        }
        return answer;
    }

    private static char getChar(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int maxValue = Arrays.stream(arr).max().getAsInt();
        for(int i = 0; i < arr.length; i++){
            if(maxValue == arr[i])list.add(i);
        }
        return (list.size() == 1) ? (char)(list.get(0) + 'a') : '?';
    }
}