package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/16968
 */
public class BaekJoon16968 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 1;
        String str = br.readLine();
        for(int i = 0; i < str.length(); i++){
            if(i == 0){
                if('c' == str.charAt(i)){
                    answer *= 26;
                }else{
                    answer *= 10;
                }
            }else{
                if(str.charAt(i) == str.charAt(i-1)){
                    if(str.charAt(i) == 'c'){
                        answer *= 25;
                    }else{
                        answer *= 9;
                    }
                }else{
                    if(str.charAt(i) == 'c'){
                        answer *= 26;
                    }else{
                        answer *= 10;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}