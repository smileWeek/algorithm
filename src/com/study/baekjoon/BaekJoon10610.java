package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/10610
 */
public class BaekJoon10610 {
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        int sum = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = charArr.length - 1; i >= 0; i--) {
            int num = charArr[i] - '0';
            sum += num;
            sb.append(num);
        }

        if(!sb.toString().endsWith("0") || sum % 3 != 0){
            System.out.println(-1);
        }else{
            System.out.println(sb);
        }
    }
}