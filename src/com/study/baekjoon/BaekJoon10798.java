package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10798
 */
public class BaekJoon10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = new String[5];
        StringTokenizer st;
        int maxSize = 0;
        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            String tmp = st.nextToken();
            strArr[i] = tmp;
            maxSize = Math.max(maxSize, tmp.length());
        }
        solution(strArr, maxSize);
    }

    private static void solution(String[] strArr, int maxSize) {
        for(int i = 0; i < maxSize; i++){
            for(int j = 0; j < strArr.length; j++){
                if(strArr[j].length() -1 < i) continue;
                System.out.print(strArr[j].charAt(i));
            }
        }
    }
}