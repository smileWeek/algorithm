package com.study.inflearn.queueAndstackQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/***
 * 4. 후위식 연산(postfix)
 * 설명
 * 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
 * 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
 *
 * 입력
 * 첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
 * 식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.
 *
 * 출력
 * 연산한 결과를 출력합니다.
 *
 * 예시 입력 1
 * 352+*9-
 *
 * 예시 출력 1
 * 12
 *
 * 2022.07.06 해결
 */
public class Question4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));
    }

    private static int solution(String str) {
        Stack<Integer> stack = new Stack<>();
        for(char s : str.toCharArray()){
            if(Character.isDigit(s))stack.push(Integer.parseInt(String.valueOf(s)));
            else{
                if (s == '+') {
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y + x);
                }else if(s == '-'){
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y - x);
                }else if(s == '*'){
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y * x);
                }else if(s == '/'){
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(y / x);
                }
            }
        }
        return stack.pop();
    }
}
