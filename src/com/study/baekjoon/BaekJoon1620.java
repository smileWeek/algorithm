package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1620
 */
public class BaekJoon1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> strMap = new HashMap<>();
        HashMap<Integer, String> numMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            String pokemon = br.readLine();
            strMap.put(pokemon, i + 1);
            numMap.put(i + 1, pokemon);
        }
        for(int i = 0; i < m; i++){
            String input = br.readLine();
            if(Character.isDigit(input.charAt(0))){
                System.out.println(numMap.get(Integer.parseInt(input)));
            }else{
                System.out.println(strMap.get(input));
            }
        }
    }
}