package com.study.inflearn.strQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/***
 * 10. 가장 짧은 문자거리
 * 설명
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
 * 문자열의 길이는 100을 넘지 않는다.
 *
 * 출력
 * 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
 *
 * 예시 입력 1
 * teachermode e
 *
 * 예시 출력 1
 * 1 0 1 2 1 0 1 2 2 1 0
 *
 * 2022.07.03 미해결 (풀이과정 참고)
 */
public class Question10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String word = st.nextToken();
        char alphabet = st.nextToken().charAt(0);
        System.out.println(Arrays.toString(solution(word,alphabet)));
    }

    private static int[] solution(String word, char alphabet) {
        int[] answer = new int[word.length()];
        int p = 1000;
        for(int i = 0 ; i < word.length(); i++){
            if(word.charAt(i) == alphabet){
                p = 0;
            }else{
                p++;
            }
            answer[i] = p;
        }
        p = 1000;
        for(int i = word.length() - 1; i >= 0; i--){
            if(word.charAt(i) == alphabet) p = 0;
            else{
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }
        return answer;
    }
}
