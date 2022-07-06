package com.study.inflearn.queAndstkQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/***
 * 1. 올바른 괄호
 * 설명
 * 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
 * (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
 *
 * 입력
 * 첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
 *
 * 출력
 * 첫 번째 줄에 YES, NO를 출력한다.
 *
 * 예시 입력 1
 * (()(()))(()
 *
 * 예시 출력 1
 * NO
 *
 * 2022.07.06 해결
 */
public class Question1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));
    }

    private static String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for(char s : str.toCharArray()){
            if(s == '(') stack.push(s);
            else{
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if(!stack.isEmpty()) answer = "NO";
        return answer;
    }
}
