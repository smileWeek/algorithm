package com.study.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] subtraction = str.split("-");
        int sum = Integer.MAX_VALUE;
        for(int i = 0; i < subtraction.length; i++){
            int tmp = 0;
            String[] addition = subtraction[i].split("\\+");
            for(int j = 0; j < addition.length; j++){
                tmp += Integer.parseInt(addition[j]);
            }
            if(sum == Integer.MAX_VALUE)sum = tmp;
            else sum -= tmp;
        }
        System.out.println(sum);
    }
}