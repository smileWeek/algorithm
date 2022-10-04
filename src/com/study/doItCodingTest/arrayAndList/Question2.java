package com.study.doItCodingTest.arrayAndList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Do it! 코딩테스트
 * https://www.acmicpc.net/problem/1546
 */
public class Question2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int maxScore = Arrays.stream(arr).mapToInt(Integer::parseInt).max().getAsInt();
        System.out.println(Arrays.stream(arr).mapToDouble(Double::parseDouble).sum() * 100 / maxScore / N);
    }
}
