package com.study.inflearn.stringQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/***
 * 6. 중복문자제거
 * 설명
 * 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
 * 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
 *
 * 입력
 * 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
 *
 * 출력
 * 첫 줄에 중복문자가 제거된 문자열을 출력합니다.
 *
 * 예시 입력 1
 * ksekkset
 *
 * 예시 출력 1
 * kset
 *
 * 2022.07.03 해결
 */
public class Question6 {
    static String answer = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br.readLine());
        System.out.println(answer);
    }

    private static void solution(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for(char s : str.toCharArray()){
            if(!list.contains(s)) list.add(s);
        }
        list.stream().map(String::valueOf).forEach(i -> answer += i);
    }
}
