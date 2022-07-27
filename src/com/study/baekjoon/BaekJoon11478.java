package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * https://www.acmicpc.net/problem/11478
 */
public class BaekJoon11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Set<String> set = new HashSet<>();
        for(int i = 1; i <= input.length(); i++){
            int lt = 0;
            int rt = i;
            while(rt <= input.length()){
                set.add(input.substring(lt++, rt++));
            }
        }
        System.out.println(set.size());
    }
}