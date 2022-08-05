package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/1439
 */
public class BaekJoon1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char c = s.charAt(0);
        int answer = 0;
        for(int rt = 1; rt < s.length(); rt++){
            if(c != s.charAt(rt)){
                answer++;
                int lt = rt;
                char tmp = s.charAt(lt);
                while(lt < s.length()){
                    if(tmp != s.charAt(lt)) break;
                    lt++;
                }
                rt = lt;
            }
        }
        System.out.println(answer);
    }
}