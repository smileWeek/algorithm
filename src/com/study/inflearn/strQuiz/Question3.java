package com.study.inflearn.strQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 3. 문장 속 단어
 * 설명
 * 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
 * 문장속의 각 단어는 공백으로 구분됩니다.
 *
 * 입력
 * 첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.
 *
 * 출력
 * 첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한
 * 단어를 답으로 합니다.
 *
 *
 * 예시 입력 1
 * it is time to study
 *
 * 예시 출력 1
 * study
 *
 * 2022.07.03 해결
 */
public class Question3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine();
        System.out.println(solution(sentence));
    }

    private static String solution(String sentence) {
        String answer = "";
        String[] tmp = sentence.split(" ");
        int size = 0;
        for(int i = 0; i < tmp.length; i++){
            if(size < tmp[i].length()){
                size = tmp[i].length();
                answer = tmp[i];
            }
        }
        return answer;
    }
}
