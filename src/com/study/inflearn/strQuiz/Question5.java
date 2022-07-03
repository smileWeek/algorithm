package com.study.inflearn.strQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * 5. 특정 문자 뒤집기
 * 설명
 * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
 * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
 *
 * 입력
 * 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
 *
 * 출력
 * 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
 *
 * 예시 입력 1
 * a#b!GE*T@S
 *
 * 예시 출력 1
 * S#T!EG*b@a
 *
 * 2022.07.03 해결
 */
public class Question5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));
    }

    private static String solution(String str) {
        char[] charArr = str.toCharArray();
        int lt = 0, rt = str.length()-1;
        while(lt < rt){
            if(Character.isAlphabetic(charArr[lt]) && Character.isAlphabetic(charArr[rt])){
                char tmp = charArr[rt];
                charArr[rt] = charArr[lt];
                charArr[lt] = tmp;
                lt++;
                rt--;
            }else if(!Character.isAlphabetic(charArr[rt])){
                rt--;
            }else if(!Character.isAlphabetic(charArr[lt])){
                lt++;
            }
        }
        return String.valueOf(charArr);
    }
}
